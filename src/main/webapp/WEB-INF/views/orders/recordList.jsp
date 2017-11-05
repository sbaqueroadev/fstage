<!------------------- Order history view. 
	In this view user can filter all orders by customer name or by creation date. 
------------------------------>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="co.com.sbaqueroa.model.implementation.*"%>
<%@page import="org.json.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<div class="container"
		ng-controller="recordListCtrlr"
	ng-init='customers = <%=new Customer().getAllJSON().toString()%>'>
	<h4>Order history</h4>
	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<label for="customer"> Customer: </label> <select class="form-control"
				name="name" ng-model="name">
				<option ng-repeat="customer in customers" value="{{customer.name}}">{{customer.name}}</option>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<label for="dateFrom"> From: </label> <input class="form-control"
				type="date" name="dateFrom" ng-model="dateFrom"
				value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" />
		</div>
		<div class="col-md-6">
			<label for="dateTo"> To: </label> <input class="form-control"
				type="date" name="dateTo" ng-model="dateTo"
				value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" />
		</div>
	</div>
	<table class="table table-bordered table-striped records-table"
		ng-init='records = <%=new OrderRecordView().getAllJSON().toString()%>'>

		<thead>
			<tr>
				<td>Creation Date</td>
				<td>Order ID</td>
				<td>Total $</td>
				<td>Delivery Address</td>
				<td>Products</td>
			</tr>
		</thead>

		<tbody>
			<tr
				ng-repeat="record in records | orderBy:sortType:sortReverse | byName:name |byDate:dateFrom:dateTo">
				<td style="display: none">{{ record.customerName }}</td>
				<td>{{ record.creationDate | date:format:"dd-MM-yyyy" }}</td>
				<td>{{ record.id }}</td>
				<td>{{ record.total | currency}}</td>
				<td>{{ record.deliveryAddress }}</td>
				<td>{{ record.productsDescription }}</td>
			</tr>
		</tbody>
	</table>
</div>