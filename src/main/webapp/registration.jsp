<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link href="/purple/css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Registrazione</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<h1>Iscriviti in Purple!</h1>
			</div>
			<div class="col"></div>
		</div>
		<div class="row" id="filler"></div>
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<c:if test="${param.username ne null}">
					<p>User o password non accettati!</p>
				</c:if>
				<form action="registration" method="post">
					<label>Username<input name="username" value="${param.username}"></label> 
					<label>Password<input name="password" type="password"></label>
					<button>Iscriviti!</button>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>