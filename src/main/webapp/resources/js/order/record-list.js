/******************************ORDER HISTORY MODULE*******************************/

/************************ LIST CONTROLLER****************************************/
mainApp.controller("recordListCtrlr", ['$scope','$q','$http',function($scope,$q,$http) {
	$scope.sortType = "id";
	$scope.dateFrom = new Date();
	$scope.dateTo = new Date();
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
            var tf = new Date(parseDate(items[i].creationDate+" GMT -0500"))
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
	return function(items, name) {
		var result = [];
		$.each(items,function(index,item){
			if (item.customerName.indexOf(name)>-1)  {
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