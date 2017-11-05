/********************************************************************************/
/************************ ORDER HISTROY MODULE CONTROLLER****************************************/
mainApp.controller("orderCtrlr", ['$scope','$q','$http',function($scope,$q,$http) {
	$scope.address = "";
	$scope.selectedProducts = [];
	$scope.selectedCustomerId = -1;
	$scope.selectedCustomerChanged = function(){
		$scope.selectedProducts = [];
		loadAvailableProducts().then(function(data){
			$scope.availableProducts = data;
		});
	};
	$scope.selectedProductsChanged = function(){
		if($scope.toFillProducts.length>5){
			alert("Just 5 products are available.");
			$scope.toFillProducts = $scope.toFillProducts.slice(0,5);
		}
		if($scope.toFillProducts.length==0)
			alert("Select at least 1 product.");
		addSelectedProducts();
		
	};
	$scope.show = function(){
		console.log($scope.selectedProducts);
	}
	/************************ SEND DATA PROCESS****************************************/
	$scope.send = function(){
		if($scope.selectedProducts.length>0)
			if($scope.selectedCustomerId>0)
				if($scope.address!==""){
					sendOrder().then(function(result){});
					return false;
				}
		alert("Check the form values and try again.");
		return false;
	};
	/********************************************************************************/
	/************************ LOAD AVAILABLE CREDITS BY CUSTOMER****************************************/
	function loadAvailableProducts(){
		var deferred = $q.defer();
		$http.get("../product/availables/"+$scope.selectedCustomerId,[{headers:"Accept=*/*"}])
		.then(function success(response){
			deferred.resolve(response.data);
		},
		function error(response){
			deferred.resolve([]);//[{id:1,name:"P1"}]);
		});
		return deferred.promise;
	}
	/********************************************************************************/
	/************************ SEND NEW ORDER****************************************/
	function sendOrder(){
		var deferred = $q.defer();
		var data = {
				customerId:$scope.selectedCustomerId,
				products:[],
				deliveryAddress:$scope.address
		};
		$.each($scope.selectedProducts,function(index,item){
			data.products.push({id:item.id,
				name:item.name,
				quantity:item.quantity});
		});
		$http.post("../order/",JSON.stringify(data))
		.then(function success(response){
			if(response.data.result=="OK"){
				$scope.selectedCustomerId = -1;
				$scope.address = "";
				$scope.toFillProducts = [];
				$scope.selectedProducts = [];
				$scope.availableProducts = [];
				$("#addOrderForm").trigger("reset");
				alert("Added correctly!");
			}else
				alert("Error. Try later please.");
			deferred.resolve(response.data);
		},
		function error(response){
			deferred.resolve();//[{id:1,name:"P1"}]);
		});
		return deferred.promise;
	}
	/********************************************************************************/
	/************************ ADD PRODUCT TO ORDER****************************************/
	function addSelectedProducts(){
		var data = new Array();
		$.each($scope.toFillProducts,function(index,item){
			$.each($scope.availableProducts,function(ind,ite){
				if(ite.id == item){
					data.push(ite);
					return false;
				}
			});
		});
		$scope.selectedProducts = data;
	}
	/********************************************************************************/
}]);

/********************************************************************************/
