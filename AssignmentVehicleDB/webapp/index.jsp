<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="models.Vehicle"%>
<%@page import="java.util.ArrayList"%>

<html>

<head>
	<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>>
	<link href="css/site.css" rel="stylesheet">
	<title>Vehicles</title>
</head>

<body>
	
	<div id="container">
	
	<header>
		<h1>Vehicle Database</h1>
		<c:if test ="${sessionScope.userLog == null}">
			<a href="./login" id="newvBtn">Login</a>
		</c:if>
		<c:if test ="${sessionScope.userLog != null}">
			<a id="logoutBtn" href="./logout">Logout</a>
		</c:if>
	</header>
	
	<div style="overflow-x:auto;">
	<table class="tableDB">
		<tr>
			<th>Vehicle ID</th>
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
			<th>Price</th>
			<th>License Number</th>
			<th>Colour</th>
			<th>Number Of Doors</th>
			<th>Transmission</th>
			<th>Mileage</th>
			<th>Fuel Type</th>
			<th>Engine Size</th>
			<th>Body Style</th>
			<th>Condition</th>
			<th>Notes</th>
			<c:if test ="${sessionScope.userLog != null}">
			<th>Options</th>
			</c:if>
			
		</tr>
		<c:forEach items="${allVehicles}" var="v">
			<tr>
				<td>${v.get_vehicle_ID()}</td>
				<td>${v.get_make()}</td>
				<td>${v.get_model()}</td>
				<td>${v.get_year()}</td>
				<td>${v.get_price()}</td>
				<td>${v.get_license_number()}</td>
				<td>${v.get_colour()}</td>
				<td>${v.get_number_doors()}</td>
				<td>${v.get_transmission()}</td>
				<td>${v.get_mileage()}</td>
				<td>${v.get_fuel_type()}</td>
				<td>${v.get_engine_size()}</td>
				<td>${v.get_body_style()}</td>
				<td>${v.get_condition()}</td>
				<td>${v.get_notes()}</td>
				<c:if test ="${sessionScope.userLog != null}">
					<td><a href="./edit?id=${v.get_vehicle_ID()}" id="editBtn">Edit</a>
					<a href="./delete?id=${v.get_vehicle_ID()}" id="delBtn">Delete</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	</div>
	<br>
	<c:if test ="${sessionScope.userLog != null}">
		<a href="./newvehicle" id="newvBtn">+ New Contact</a>
	</c:if>
	</div>
</body>
</html>