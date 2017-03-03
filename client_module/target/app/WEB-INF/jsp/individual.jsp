<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script language="JavaScript">
var contextPath = "<%=request.getContextPath()%>";
var app = angular.module("myApp", []);
app.controller("indivCtrl", function($scope) {
	$scope.caseCategories = getCaseCategories();
	$scope.involvedParties = getInvolvedParties();
	$scope.countries = getCountries();
	$scope.states = getStates();
	$scope.reset = function() {
		$scope.caseReference = "Case refence";
		$scope.involvedParty = "Involved party case reference";
		$scope.imxCaseReference = "iMX case reference";
		$scope.individualReference = "Individual reference";
		$scope.internalIndividualReference = "Internal individual reference";
		$scope.legalIdentifier = "Legal Identifier";
		$scope.involvedParties = "";
		$scope.nameOrCorporateName = "Name or corporate name";
		$scope.firstName = "First name";
		$scope.birthdate = "Birth date";
		$scope.phone = "Phone";
		$scope.country = "";
		$scope.state = "";
		$scope.city = "City";
		$scope.postCode = "Post code";
		$scope.address = "Address";
		$scope.email = "Email";
		$scope.binBan = "BIN/BAN";
		$scope.activeCases = false;
		$scope.includeArchivedCases = true;
		$scope.caseCategory = "";
	}
});

function getStates() {
	var success;
	$.ajax({
		type: "GET",
		url: contextPath + "/indiv/getStates",
		async: false,
		success: function(data) {
			success = data;
		}
	});
	return success;	
}
function getCaseCategories() {
	var success;
	$.ajax({
		type: "GET",
		url: contextPath + "/indiv/getCaseCategories",
		async: false,
		success: function(data) {
			success = data;
		}
	});
	return success;	
}
function getCountries() {
	var success;
	$.ajax({
		type: "GET",
		url: contextPath + "/indiv/getCountries",
		async: false,
		success: function(data) {
			success = data;
		}
	});
	return success;	
}
function getInvolvedParties() {
	var success;
	$.ajax({
		type: "GET",
		url: contextPath + "/indiv/getInvolvedParties",
		async: false,
		success: function(data) {
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
		<form class="form-inline">
			<div class="form-group" style="width: 1024px;">
				<label for="caseReference" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Case reference *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="caseReference" placeholder="Enter Case reference" style="width: 250px;" ng-model="caseReference">
				</div>
				<label for="involvedParty" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Involved party case reference *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="involvedParty" placeholder="Enter Involved Party" style="width: 250px;" ng-model="involvedParty">
				</div>
			</div>
			<div class="form-group" style="margin-top: 20px; width: 1024px;">
				<label for="imxCaseReference" class="col-xs-2 control-label" style="width: 170px; text-align: right;">iMX Case reference *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="imxCaseReference" placeholder="Enter iMX Case reference" style="width: 250px;" ng-model="imxCaseReference">
				</div>
				<label for="caseCategory" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Case category</label>
				<div class="col-xs-4">
					<select class="form-control" id="caseCategory" style="width: 250px;" ng-model="caseCategory" ng-options="item.id as item.name for item in caseCategories" >
					</select>
				</div>
			</div>
			<div class="form-group" style="margin-top: 18px; width: 1024px;">
				<label for="individualReference" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Individual's refernence *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="individualReference" placeholder="Enter iMX Case reference" style="width: 250px;" ng-model="individualReference">
				</div>
				<label for="internalIndividualReference" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Internal Individual's reference *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="internalIndividualReference" placeholder="Enter Case category" style="width: 250px;" ng-model="internalIndividualReference">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="legalIdentifier" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Legal Identifier *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="legalIdentifier" placeholder="Enter Legal Identifier" style="width: 250px;" ng-model="legalIdentifier">
				</div>
				<label for="involvedParties" class="col-xs-2 control-label" style="width: 170px; text-align: right;">List of Involved parties</label>
				<div class="col-xs-4">
					<select class="form-control" id="involvedParties" style="width: 250px;" ng-model="involvedParties" ng-options="item.id as item.name for item in involvedParties">
					</select>
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="nameOrCorporateName" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Name or corporate name *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="nameOrCorporateName" placeholder="Enter Name or corporate name" style="width: 250px;" ng-model="nameOrCorporateName">
				</div>
				<label for="firstName" class="col-xs-2 control-label" style="width: 170px; text-align: right;">First name</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="firstName" placeholder="Enter First name" style="width: 250px;" ng-model="firstName">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label class="col-xs-2 control-label" style="width: 170px; text-align: right;"></label>
				<div class="col-xs-4">
				</div>
				<label for="birthdate" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Birth date</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="birthdate" placeholder="Enter birth date" style="width: 250px;" ng-model="birthdate">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="phone" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Phone *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="phone" placeholder="Enter phone" style="width: 250px;" ng-model="phone">
				</div>
				<label for="country" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Country</label>
				<div class="col-xs-4">
					<select class="form-control" id="country" style="width: 250px;" ng-model="country">
						<option></option>
						<option>Hello 1</option>
						<option>Hello 2</option>
					</select>
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="state" class="col-xs-2 control-label" style="width: 170px; text-align: right;">State</label>
				<div class="col-xs-4">
					<select class="form-control" id="state" style="width: 250px;" ng-model="state">
						<option></option>
						<option>Hello 1</option>
						<option>Hello 2</option>
					</select>
				</div>
				<label for="city" class="col-xs-2 control-label" style="width: 170px; text-align: right;">City</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id=city" placeholder="Enter city" style="width: 250px;" ng-model="city">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="postCode" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Post code *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="postCode" placeholder="Enter post code" style="width: 250px;" ng-model="postCode">
				</div>
				<label for="address" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Address</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id=address" placeholder="Enter address" style="width: 250px;" ng-model="address">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="email" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Email *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="email" placeholder="Enter email" style="width: 250px;" ng-model="email">
				</div>
				<label for="binBan" class="col-xs-2 control-label" style="width: 170px; text-align: right;">BIN/BAN* *</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id=binBan" placeholder="Enter BIN/BAN" style="width: 250px;" ng-model="binBan">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label class="col-xs-2 control-label" style="width: 170px; text-align: right;"></label>
				<div class="col-xs-4">
				</div>
				<label for="activeCases" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Active cases</label>
				<div class="col-xs-4">
					<input type="checkbox" class="form-control" id="activeCases" style="margin-left: 80px; height: 18px;" ng-model="activeCases">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label for="includeArchivedCases" class="col-xs-2 control-label" style="width: 170px; text-align: right;">Include archived cases</label>
				<div class="col-xs-4">
					<input type="checkbox" class="form-control" id="includeArchivedCases" style="margin-left: 80px; height: 18px;" ng-model="includeArchivedCases">
				</div>
				<label class="col-xs-2 control-label" style="width: 170px; text-align: right;"></label>
				<div class="col-xs-4">
				</div>
			</div>
			<div class="form-group" style="margin-top: 15px; width: 1024px;">
				<label class="col-xs-2 control-label" style="width: 170px; text-align: right;"></label>
				<div class="col-xs-4">
				</div>
				<label for="activeCases" class="col-xs-2 control-label" style="width: 170px; text-align: right;"></label>
				<div class="col-xs-4" style="text-align: right;">
					<button class="btn btn-primary" type="button">> Search</button>
					<button class="btn btn-primary" type="button" ng-click="reset()">X Reset</button>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>