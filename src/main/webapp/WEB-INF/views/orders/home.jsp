<!-- Order main file that includes in tabs the available views -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Orders managment</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<link rel="stylesheet" href="../resources/css/order/style.css"/>
<body>
<h2>Ordenes</h2>
	<div>

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#addOrder"
				aria-controls="addOrder" role="tab" data-toggle="tab">Add Order</a></li>
			<li role="presentation"><a href="#record" aria-controls="record"
				role="tab" data-toggle="tab">Record List</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content content" ng-app='addorderapp'>
			<div role="tabpanel" class="tab-pane fade in active" id="addOrder">
<!------------------- Include add order process view ---------------------------->
				<jsp:include page="addForm.jsp"></jsp:include>
			</div>
			<div role="tabpanel" class="tab-pane fade" id="record">
<!------------------- Include order record view ---------------------------->
				<jsp:include page="recordList.jsp"></jsp:include>
			</div>
		</div>

	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="../resources/js/order/main.js"></script>
	<script type="text/javascript" src="../resources/js/order/add-order.js"></script>
	<script type="text/javascript" src="../resources/js/order/record-list.js"></script>
	
</body>
</html>
