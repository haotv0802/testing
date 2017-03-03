/**
 * 
 */
package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.dao.DAOBase;
import com.dao.UserDAO;
import com.dao.model.UserModel;

/**
 * @author haho
 *
 */
@Repository
public class UserDAOImpl extends DAOBase implements UserDAO {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	private final DataSource dataSource;

	private final JdbcTemplate jdbc;

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbc = new JdbcTemplate(dataSource);
		this.jdbcTemplate = new NamedParameterJdbcTemplate(this.jdbc);
	}

	public UserModel getUserByUsername(String username) {
		String sql = "SELECT `USER_NAME`, `PASSWORD` FROM `security_db`.`user_table` WHERE `USER_NAME` = :username";
		
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.debug("=============== start SQL query");
			this.LOGGER.info("sql: " + sql);
		}
		MapSqlParameterSource paramsMap = new MapSqlParameterSource();
		if (!StringUtils.isEmpty(username)) {
			paramsMap.addValue("username", username);
		}
		UserHandler userHandler = new UserHandler();
		jdbcTemplate.query(sql, paramsMap, userHandler);

		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.debug("=============== end SQL query");
		}
		return userHandler.getResult();
	}
}

class UserHandler implements RowCallbackHandler {

	private UserModel userModel;

	public void processRow(ResultSet rs) throws SQLException {
		userModel = new UserModel();
		userModel.setUserName(rs.getString("USER_NAME"));
		userModel.setPassword(rs.getString("PASSWORD"));
	}

	public UserModel getResult() {
		return userModel;
	}
}
