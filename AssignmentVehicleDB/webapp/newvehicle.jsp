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
		<h1>Insert New Vehicle ${vehicle_ID}</h1>	
	</header>

	<div id="divInputs">
	<form method="POST" action="./newvehicle">
		Make: <br>
		<input type="text" name="make">
		<br>
		Model <br>
		<input type="text" name="model">
		<br>
		Year: <br>
		<input type="text" name="year">
		<br>
		Price: <br>
		<input type="text" name="price">
		<br>
		License Number: <br> 
		<input type="text" name="license_number">
		<br>
		Colour: <br> 
		<input type="text" name="colour">
		<br>
		Number of doors: <br> 
		<input type="text" name="number_doors">
		<br>
		Transmission (Manual/Auto): <br>
		<input type="text" name="transmission">
		<br>
		Mileage: <br>
		<input type="text" name="mileage">
		<br>
		Fuel type (Diesel, Petrol, Hybrid, Electric): <br>
		<input type="text" name="fuel_type">
		<br>
		Engine size (cc): <br> 
		<input type="text" name="engine_size">
		<br>
		Body style (Hatchback, Estate, SUV, MVP Coupe): <br>
		<input type="text" name="body_style">
		<br>
		Condition (Like new, Good, Fair etc...): <br> 
		<input type="text" name="condition">
		<br>
		Notes (Special Features): <br> 
		<input type="text" name="notes">
		<br>
		<input type="submit">
	</form>
	</div>

</body>

</html>