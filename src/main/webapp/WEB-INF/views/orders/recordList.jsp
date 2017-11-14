<!------------------- Order history view. 
	In this view user can filter all orders by customer name or by creation date. 
------------------------------>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="co.com.sbaqueroa.model.implementation.*"%>
<%@page import="co.com.sbaqueroa.services.*"%>
<%@page import="org.json.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<div id="record-container" class="container"
		ng-controller="recordListCtrlr"
	ng-init='customers = []'>
	<h4>Order history</h4>
	<div class="row">
		<div class="col-md-offset-9 col-md-3 reload-button">
			<a href="#" ng-click="loadData()">REFRESH</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<label for="customer"> Customer: </label> 
			<select class="form-control"
				name="name" data-ng-model="name"
				data-ng-options="customer.name for customer in customers">
				<!-- <option ng-repeat="customer in customers" value="{{customer.name}}">{{customer.name}}</option>-->
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
		ng-init='records = []'>

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
				<td>{{ record.order.creationDate | date:format:"dd-MM-yyyy" }}</td>
				<td>{{ record.order.id }}</td>
				<td>{{ record.total | currency}}</td>
				<td>{{ record.order.deliveryAddress }}</td>
				<td>{{ record.productsDescription }}</td>
			</tr>
		</tbody>
	</table>
</div>