/******************************ORDER HISTORY MODULE*******************************/

/************************ LIST CONTROLLER****************************************/
mainApp.controller("recordListCtrlr", ['$scope','$q','$http',function($scope,$q,$http) {
	$scope.sortType = "id";
	$scope.dateFrom = new Date();
	$scope.dateTo = new Date();
	$scope.loadData = function(){
		var aux = $scope.name;
		$scope.name = undefined;
		$http.get("../customer/")
		.then(function success(response){
			$scope.customers = response.data;
			$.each($scope.customers,function(index,item){
				if (item.name.indexOf(aux.name)>-1)  {
					$scope.name = $scope.customers[index];    
				}            
	        });
				
				//$('#record-container select[name="name"] option[value="'+$scope.name+'"]').attr("selected","selected");
		},
		function error(response){
			$scope.customers = [];
		});
		$http.get("../orderRecordView/")
		.then(function success(response){
			$scope.records = response.data;
		},
		function error(response){
			$scope.records = [];
		});
	};
	$scope.loadData();
}]);
/********************************************************************************/
/************************ CUSTOM FILTERS****************************************/
/************************ CREATION DATE FILTER****************************************/
mainApp.filter("byDate",function(){
	return function(items, from, to) {
        var df = from;
        var dt = to;
        df.setHours(0,0,0,0);
        dt.setHours(23,59,59,999);
        var result = [];        
        for (var i=0; i<items.length; i++){
            var tf = new Date();
            tf.setTime(items[i].order.creationDate);
            if (tf >= df && tf <= dt)  {
                result.push(items[i]);
            }
        }            
        return result;
  };
});
/********************************************************************************/
/************************ CUSTOMER NAME FILTER****************************************/
mainApp.filter("byName",function(){
	return function(items, customer) {
		var result = [];
		$.each(items,function(index,item){
			if (item.customerName.indexOf(customer.name)>-1)  {
                result.push(item);
			}            
        });
        return result;
  };
});
/********************************************************************************/
/************************ DATE PARSE FUNCTION****************************************/
function parseDate(date){
	return Date.parse(date);
}
/********************************************************************************/