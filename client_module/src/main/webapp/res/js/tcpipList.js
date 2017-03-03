
	function setBackgroundColorForTRTag(trTag, color) {
		$(trTag).css("background-color", color);
	}
	var app = angular.module('myApp', []);
	app.controller("tcpipCtrl", function($scope) {
		//$scope.loading = true;
		$scope.tcpipListTemp = null;
		$scope.numberOfPages = numberOfPages;
		$("#addressImgId").attr("src", upArrow);
		$("#aliasImgId").attr("src", upArrow);
		$("#ttyImgId").attr("src", upArrow);
		$("#loginImgId").attr("src", upArrow);
		$("#tdt1ImgId").attr("src", upArrow);
		$("#tdt2ImgId").attr("src", upArrow);
		$("#imgrImgId").attr("src", upArrow);
		$("#traceLevelImgId").attr("src", upArrow);
		$scope.range = function(n) {
			return new Array(n);
		};
		$scope.traceLevelList = traceLevelList;
		var jsonResponse = JSON.parse(getTCPIPListFiltering(position, "", "", "", "", "", "", null, ""));
		if (jsonResponse.success == true) {
			$scope.tcpipList = jsonResponse.data;
		} else {
			alert(jsonResponse.message);
		}
//		$scope.tcpipListTemp = JSON.parse(getTCPIPListFiltering(position, "", "", "", "", "", "", null, "")); 
		/* $scope.tcpipList = [
		                { "adresse" : "Max Joe", "alias" : "Lulea", "tty" : "Sweden" },
		                { "adresse" : "Manish", "alias" : "Delhi", "tty" : "India" },
		                { "adresse" : "Koniglich", "alias" : "Barcelona", "tty" : "Spain" },
		                { "adresse" : "Wolski", "alias" : "Arhus", "tty" : "Denmark" },
		                { "adresse" : "Wolski", "alias" : "Arhus", "tty" : "Denmark" },
		                { "adresse" : "Manish", "alias" : "Delhi", "tty" : "India" },
		                { "adresse" : "Wolski", "alias" : "Arhus", "tty" : "Denmark" },
		                { "adresse" : "Koniglich", "alias" : "Barcelona", "tty" : "Spain" },
		                { "adresse" : "Wolski", "alias" : "Arhus", "tty" : "Denmark" }
		              ]; */
		$scope.displayTCPIPList = function(positionParam) {
		    position = positionParam;
			//$scope.tcpipList = JSON.parse(getTCPIPListFiltering(position, "", "", "", "", "", "", null, ""));
		    var jsonResponse = JSON.parse(getTCPIPListFiltering(position, "", "", "", "", "", "", null, ""));
		    if (jsonResponse.success == true) {
				$scope.tcpipList = jsonResponse.data;
			} else {
				alert(jsonResponse.message);
			}
		};

		$scope.notifyChanges = function(tty, index) {
			isChanged = true;
//			alert(isChanged);
//			alert($scope.tcpipList[index].adresse);
			$scope.tcpipList[index].adresse = $("#tcpipAdresse" + tty).val() == "" ? null : $("#tcpipAdresse" + tty).val();;
			$scope.tcpipList[index].login = $("#tcpipLogin" + tty).val() == "" ? null : $("#tcpipLogin" + tty).val();
			$scope.tcpipList[index].alias = $("#tcpipAlias" + tty).val() == "" ? null : $("#tcpipAlias" + tty).val();;
			$scope.tcpipList[index].tty = $("#tcpipTty" + tty).val() == "" ? null : $("#tcpipTty" + tty).val();;
			$scope.tcpipList[index].tdt1 = $("#tcpipTdt1" + tty).val() == "" ? null : $("#tcpipTdt1" + tty).val();;
			$scope.tcpipList[index].tdt2 = $("#tcpipTdt2" + tty).val() == "" ? null : $("#tcpipTdt2" + tty).val();;
			$scope.tcpipList[index].imagerie = $("#tcpipImagerie" + tty).val() == "" ? null : $("#tcpipImagerie" + tty).val();
//			alert($scope.tcpipList[index].adresse);
			$("#updateId").removeAttr("disabled");
		};

		$scope.updateTCPIPList = function() {
//			alert($scope.tcpipList[0].adresse);
			var jsonResponse = updateTCPIPList(JSON.stringify($scope.tcpipList));
			//jsonResponse = JSON.parse(jsonResponse);
			if (jsonResponse.success == false) {
				//$( "#dialog" ).dialog();
				alert(jsonResponse.message);
				//$scope.tcpipList = JSON.parse(getTCPIPListFiltering(0, "", "", "", "", "", "", null, ""));
				var jsonResponse = JSON.parse(getTCPIPListFiltering(0, "", "", "", "", "", "", null, ""));
				if (jsonResponse.success == true) {
					$scope.tcpipList = jsonResponse.data;
				} else {
					alert(jsonResponse.message);
				}
			}
		};

		$scope.filterValues = function() {
			var address = $scope.addressFilter != null ? $scope.addressFilter : "";
			var alias = $scope.aliasFilter != null ? $scope.aliasFilter : "";
			var tty = $scope.ttyFilter != null ? $scope.ttyFilter : "";
			var login = $scope.loginFilter != null ? $scope.loginFilter : "";
			var tdt1 = $scope.tdt1Filter != null ? $scope.tdt1Filter : "";
			var tdt2 = $scope.tdt2Filter != null ? $scope.tdt2Filter : "";
			var imagerie = $scope.imgrFilter != null ? $scope.imgrFilter : "";
			var tracing = $scope.tracingFilter != null ? $scope.tracingFilter : "";

			//var jsonData = JSON.parse(getTCPIPListFiltering(0, address, alias, login, tdt1, tdt2, imagerie, tracing, tty));
			var jsonResponse = JSON.parse(getTCPIPListFiltering(0, address, alias, login, tdt1, tdt2, imagerie, tracing, tty));
			if (jsonResponse.success == true) {
				$scope.tcpipList = jsonResponse.data;
			} else {
				alert(jsonResponse.message);
			}
			var totalItems = getNumberOfItems(address, alias, login, tdt1, tdt2, imagerie, tracing, tty);
			//alert("numberOfPages: " + numberOfPages);
			$scope.tcpipList =  jsonData;
			//alert(address + alias + tty);
			
			$scope.numberOfPages = Math.ceil(totalItems / pageSize);
			//alert("$scope.numberOfPages: " + $scope.numberOfPages);
			//$scope.$apply();
		};
		$scope.sortValues = function(sortFieldParam) {
			if (sortFieldParam == "adresse") {
				// change arrow to opposite
				if ($("#addressImgId").attr("src") == upArrow) {
					$("#addressImgId").attr("src", downArrow);
				} else {
					$("#addressImgId").attr("src", upArrow);
				}
				// change other arrows back to normal
				$("#aliasImgId").attr("src", upArrow);
				$("#ttyImgId").attr("src", upArrow);
			}
			if (sortFieldParam == "alias") {
				// change arrow to opposite
				if ($("#aliasImgId").attr("src") == upArrow) {
					$("#aliasImgId").attr("src", downArrow);
				} else {
					$("#aliasImgId").attr("src", upArrow);
				}
				// change other arrows back to normal
				$("#addressImgId").attr("src", upArrow);
				$("#ttyImgId").attr("src", upArrow);
			}
			if (sortFieldParam == "tty") {
				// change arrow to opposite
				if ($("#ttyImgId").attr("src") == upArrow) {
					$("#ttyImgId").attr("src", downArrow);
				} else {
					$("#ttyImgId").attr("src", upArrow);
				}
				// change other arrows back to normal
				$("#addressImgId").attr("src", upArrow);
				$("#aliasImgId").attr("src", upArrow);
			}
			
			if (sortField == sortFieldParam) {
				if (sortOrder == "ASC") {
					sortOrder = "DESC";
				} else {
					sortOrder = "ASC";
				}
			} else {
				sortOrder = "DESC";
			}
			sortField = sortFieldParam;
			var address = $scope.addressFilter != null ? $scope.addressFilter : "";
			var alias = $scope.aliasFilter != null ? $scope.aliasFilter : "";
			var tty = $scope.ttyFilter != null ? $scope.ttyFilter : "";
			var tdt1 = $scope.tdt1Filter != null ? $scope.tdt1Filter : "";
			var tdt2 = $scope.tdt2Filter != null ? $scope.tdt2Filter : "";
			var login = $scope.loginFilter != null ? $scope.loginFilter : "";
			var imagerie = $scope.imgrFilter != null ? $scope.imgrFilter : "";
			var tracing = $scope.tracingFilter != null ? $scope.tracingFilter : "";

			//$scope.tcpipList = JSON.parse(getTCPIPListFiltering(position, address, alias, login, tdt1, tdt2, imagerie, null, tty)); 
			var jsonResponse = JSON.parse(getTCPIPListFiltering(position, address, alias, login, tdt1, tdt2, imagerie, null, tty)); 
			if (jsonResponse.success == true) {
				$scope.tcpipList = jsonResponse.data;
			} else {
				alert(jsonResponse.message);
			}
		};
	});
	
	function getNumberOfItems(address, alias, login, tdt1, tdt2, imagerie, tracing, tty) {
		var success;
		$.ajax({
	        type: "GET",
	        url: contextPath + "/tcpip/getNumberOfItems.imx",
       		data: ({
   	        	adresse: address,
   	        	alias: alias,
   	        	login: login,
   	        	tdt1: tdt1,
   	        	tdt2: tdt2,
   	        	imagerie: imagerie,
   	        	tracing: tracing,
   	        	tty: tty
   	            }),
	        async: false,
	        success: function(data) {
	           //alert(data);
	        	success = data;
	        }
		});
		return success;
	}
	
	function getTCPIPListFiltering(positionParam, address, alias, login, tdt1, tdt2, imagerie, tracing, tty) {
		var success;
		$.ajax({
	        type: "GET",
	        url: contextPath + "/tcpip/getTCPIPListFiltering.do",
       		data: ({
   	        	position: positionParam,
   	        	pageSize: pageSize,
   	        	adresse: address,
   	        	alias: alias,
   	        	login: login,
   	        	tdt1: tdt1,
   	        	tdt2: tdt2,
   	        	imagerie: imagerie,
   	        	tracing: tracing,
   	        	tty: tty,
   	        	sortField: sortField,
   	        	sortOrder: sortOrder
   	            }),
	        async: false,
	        success: function(data) {
	           //alert(data);
	        	success = data;
	        }
		});
		return success;
	}
	

	function updateTCPIPList(tcpipList) {
		var success = "";
		$.ajax({
			type : "GET",
			url : contextPath + "/tcpip/updateTCPIPList.imx",
			data : ({
				tcpipList : tcpipList
			}),
			async : false,
			success : function(data) {
				//alert(data);
				success = data;
			}
		});
		return JSON.parse(success);
	}
