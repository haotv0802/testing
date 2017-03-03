<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script language="JavaScript">
var contextPath = "<%=request.getContextPath()%>";
var app = angular.module("myApp", []);
app.controller("indivCtrl", function($scope) {
	$scope.indivList = getIndivList();
});

function getIndivList() {
	var success;
	$.ajax({
        type: "GET",
        url: contextPath + "/indiv/getIndivList",
        async: false,
        success: function(data) {
           //alert(data);
       	   success = data;
        }
	});
	return success;
}

</script>

<html>
	<body>
		<br />
		<div ng-app="myApp" ng-controller="indivCtrl">
			<table style="width: 1024px;" class="table table-striped table-hover">
					<tr>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
						<th style="width: 130px;">
							<input type="text" size=10px/>
						</th>
					</tr>
					<tr ng-repeat="indiv in indivList track by $index">
						<td style="width: 130px;">
							<a href="" style="text-decoration: underline;">{{indiv.imxRef}}</a>
						</td>
						<td style="width: 130px;">
							<span>{{indiv.caseRef}}</span>
						</td>
						<td style="width: 130px;">
							<span>{{indiv.subRef}}</span>
						</td>
						<td style="width: 130px;">
							<span>{{indiv.caseCategory}}</span>
						</td>
						<td style="width: 130px;">
							<span>{{indiv.currency}}</span>
						</td>
						<td style="width: 130px;">
							<span>{{indiv.client}}</span>
						</td>
						<td style="width: 130px;">
							<span>{{indiv.debtor}}</span>
						</td>
					</tr>
			</table>
		</div>	
	</body>
</html>