<!------------------- Add order Form view 
	After submitting, new order is added.
------------------------------>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="co.com.sbaqueroa.model.implementation.*"%>
<%@page import="org.json.*"%>
<div>
	<h4>Add Order</h4>
	<form id="addOrderForm" ng-controller="orderCtrlr as vm"
		ng-init='customers = <%=new Customer().getAllJSON().toString()%>'
		ng-submit="send()" class="col-md-offset-1 col-md-10">
		<div class="col-md-4">
			<label for="customer"> Customer: </label> <select name="customer"
				class="form-control" ng-model="selectedCustomerId"
				ng-change="selectedCustomerChanged()" required>
				<option ng-repeat="customer in customers" value="{{customer.id}}">{{customer.name}}</option>
			</select>
		</div>
		<div class="col-md-offset-2 col-md-6">
			<label for="address">Delivery address:</label> <input
				class="form-control" id="address" type="text" name="address"
				ng-model="address" required />
		</div>
		<hr>
		<div class="col-md-6">
			<label for="products"> Available products: </label> <select
				class="form-control" multiple="multiple" name="products"
				ng-model="toFillProducts" ng-change="selectedProductsChanged()">
				<option ng-repeat="product in availableProducts"
					value="{{product.id}}">{{product.name}}</option>
			</select>
		</div>
		<div class="col-md-6">
			<div ng-repeat="product in selectedProducts">
				<label for="product_{{product.id}}"> Quantity
					{{product.name}}: </label> <input id="product_{{product.id}}" type="number"
					required value="1" ng-model="selectedProducts[$index].quantity"
					class="form-control" />
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-offset-5 col-md-2">
				<input class="form-control btn btn-success" type="submit"
					value="Enviar" />
			</div>
		</div>
	</form>
</div>