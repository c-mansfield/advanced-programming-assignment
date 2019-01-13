<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" content="text/html; charset=UTF-8">
	<title>Inserting New Vehicle</title>
	<link href="css/site.css" rel="stylesheet">
</head>

<body>
	<header>
		<h1>Editing Vehicle ${vehicle.get_vehicle_ID()}</h1>	
	</header>
	
	<div id="divInputs">
	<form method="POST" action="./edit">
		Make: <br>
		<input type="text" name="make" value="${vehicle.get_make()}">
		<br>
		Model: <br>
		<input type="text" name="model" value="${vehicle.get_model()}">
		<br>
		Year: <br>
		<input type="text" name="year" value="${vehicle.get_year()}">
		<br>
		Price: <br>
		<input type="text" name="price" value="${vehicle.get_price()}">
		<br>
		License Number: <br>
		<input type="text" name="license_number" value="${vehicle.get_license_number()}">
		<br>
		Colour: <br>
		<input type="text" name="colour" value="${vehicle.get_colour()}">
		<br>
		Number of doors: <br>
		<input type="text" name="number_doors" value="${vehicle.get_number_doors()}">
		<br>
		Transmission (Manual/Auto): <br>
		<input type="text" name="transmission" value="${vehicle.get_transmission()}">
		<br>
		Mileage: <br>
		<input type="text" name="mileage" value="${vehicle.get_mileage()}">
		<br>
		Fuel type (Diesel, Petrol, Hybrid, Electric): <br>
		<input type="text" name="fuel_type" value="${vehicle.get_fuel_type()}">
		<br>
		Engine size (cc): <br><input type="text" name="engine_size" value="${vehicle.get_engine_size()}">
		<br>
		Body style (Hatchback, Estate, SUV, MVP Coupe): <br>
		<input type="text" name="body_style" value="${vehicle.get_body_style()}">
		<br>
		Condition (Like new, Good, Fair etc...): <br><input type="text" name="condition" value="${vehicle.get_condition()}">
		<br>
		Notes (Special Features): <br>
		<input type="text" name="notes" value="${vehicle.get_notes()}">
		<br>
		<input type="submit">
	</form>
	</div>
	
</body>

</html>