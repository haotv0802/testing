<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script language="JavaScript">
var contextPath = "<%=request.getContextPath()%>";
var app = angular.module("loginApp", []);
app.controller("loginCtrl", function($scope) {
	//alert(contextPath);
	$scope.login = function() {
		//alert($scope.username + ", " + $scope.password);
		login($scope.username, $scope.password);
	}
	$scope.reset = function() {
    	$scope.username = "Ho Anh Hao";
    	$scope.password = "";
    }
    //$scope.reset();	
})

function login(u, p) {
	var success;
	var loginInfo = {username : u, password : p };
	$.ajax({
        type: "POST",
        url: contextPath + "/login",
        dataType: "json",
        data: JSON.stringify(loginInfo),
        async: false,
        complete: function(xhr, statusText){
            //alert(xhr.status);
            //alert(statusText);
            //alert(xhr.getAllResponseHeaders());
            window.location = contextPath + "/indiv/displayIndivList";
        }
	});
	return success;
}
</script>

<html>
	<body>
		<section id="content">
		<br />
			<form:form action="login" method="POST" ng-app="loginApp" ng-controller="loginCtrl">
				<table>
					<tr>
						<td>Username:</td>
						<td><input type='text' name="username" ng-model="username"/></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name="password" ng-model="password"></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="button" value="Login" ng-click="login()">&nbsp;<input name="reset" value="Reset" type="button" ng-click="reset()"></td>
					</tr>
				</table>
			</form:form>
		</section>
	</body>
</html>