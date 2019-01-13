<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="css/site.css" rel="stylesheet">
	<title>Login</title>
</head>

<body>
	
	<div id="container">
	
	<header>
		<h1>Administrator Login</h1>
	</header>
	
	<div id="divInputs">
	<form method="POST" action="./login">
		Username: <br>
		<input type="text" name="username">
		<br><br>
		Password: <br>
		<input type="password" name="password">
		<br><br>
		<input type="submit">
	</form>
	</div>
	
	</div>
</body>
</html>