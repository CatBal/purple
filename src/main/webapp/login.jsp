<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<c:if test="${param.username ne null}">
<p>Username o password errata!</p>
</c:if>
<form action="login" method="post">
<label>Username<input name="username" value="${param.username}"></label>
<label>Password<input type="password"></label>
<button>ok!</button>
</form>
</body>
</html>