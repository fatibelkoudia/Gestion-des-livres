<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gestion des livres - Login</title>

<link href="<c:url value="/resources/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
<style>

html, body {
	height: 100%;
	width: 100%;
	margin: 0;
}

body {
	background: #c0c0c0; 
	display: flex;
}

.container {
  margin: 20px auto;
  padding: 40px 50px;
  max-width: 300px;
  border-radius: 5px;
  background: #fff;
  box-shadow: 1px 1px 1px #666;
  margin:auto;
}

 .message{
 	color: #ED4337;
 	font-weight: bold;
 }
</style>
</head>

<body>
<div class="container">
	<form action="/gr1Tp1/login" method="post">
	
	<div class="form-group">
					<label>Login:</label> <input type="text" name="login"
						 
						class="form-control" required />

				</div>
				
				<div class="form-group">
					<label>Password:</label> <input type="password" name="password"
						 
						class="form-control" required />

				</div>
				
				<div class="form-group"><input
			type="submit" class="btn btn-success" value="Login"></div>

		<div class="message"><c:out value='${message}' /></div>
	</form>
	</div>
</body>
</html>