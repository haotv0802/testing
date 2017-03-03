/**
 * 
 */
package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.dao.DAOBase;
import com.dao.RoleDAO;
import com.dao.model.RoleModel;

/**
 * @author haho
 *
 */
@Repository
public class RoleDAOImpl extends DAOBase implements RoleDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	private final DataSource dataSource;

	private final JdbcTemplate jdbc;
	
	@Autowired
	public RoleDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbc = new JdbcTemplate(dataSource);
		this.jdbcTemplate = new NamedParameterJdbcTemplate(this.jdbc);
	}

	public List<RoleModel> getRolesByUsername(String username) {
//		this.insertRoleDetails(43, "43");
		String sql = "SELECT `ROLE_NAME` FROM "
				+ "((`security_db`.`user_role_table` U INNER JOIN `security_db`.`user_role_details_table` D ON U.ID = D.ROLE_ID) "
				+ "INNER JOIN `security_db`.`user_table` T ON T.ID = D.USER_ID) WHERE T.USER_NAME = :username";
		
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.debug("=============== start SQL query");
			this.LOGGER.info("sql: " + sql);
		}
		MapSqlParameterSource paramsMap = new MapSqlParameterSource();
		if (!StringUtils.isEmpty(username)) {
			paramsMap.addValue("username", username);
		}
		RoleHandler userHandler = new RoleHandler();
		jdbcTemplate.query(sql, paramsMap, userHandler);

		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.debug("=============== end SQL query");
		}
		return userHandler.getResult();
	}

	public void insertRoleDetails(int id, String name) {
		String sql = "INSERT INTO `security_db`.`user_table`(`ID`, `USER_NAME`, `PASSWORD`) VALUES (:id, :name, 'hoanhhao')";
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		sqlParameterSource.addValue("id", id);
		sqlParameterSource.addValue("name", id);
		jdbcTemplate.update(sql, sqlParameterSource);
	}
}

class RoleHandler implements RowCallbackHandler {

	private List<RoleModel> roleModelList = new ArrayList<RoleModel>();;

	public void processRow(ResultSet rs) throws SQLException {
		RoleModel roleModel = new RoleModel();
		roleModel.setRoleName(rs.getString("ROLE_NAME"));
		roleModelList.add(roleModel);
	}

	public List<RoleModel> getResult() {
		return roleModelList;
	}
}
