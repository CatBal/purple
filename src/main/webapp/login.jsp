<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="/purple/css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col my1"></div>
            <div class="col my2"><h1>Purple Login</h1></div>
            <div class="col my1"></div>
        </div>
          <div class="row">
            <div class="col my1"></div>
            <div class="col my2">
            <c:if test="${param.username ne null}">
<p>Username o password errata!</p>
</c:if>
<form action="login" method="post">
    <label>Username<input name="username" value="${param.username}"></label>
    <label>Password<input name="password" type="password"></label>
    <button>ok!</button>
</form>
            </div>
            <div class="col my1"></div>
        </div>

     

</body>
</html>