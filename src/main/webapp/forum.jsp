<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link href="/purple/css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Forum disponibili</title>
</head>
<body>
<div class="container-fluid">
        <div class="row">
            <div class="col"></div>
            <div class="col"><h1>Purple Forum</h1></div>
            <div class="col"></div>
        </div>
</div>
<h1>Forum disponibili</h1>
<!-- 1.lista completa per utente non registrato -->
<p>Tutti i forum: ${forum}</p>
<!-- 2. lista dei forum a cui è iscritto l'utente -->
<p>Tutti i miei forum: ${myForum}</p>
<!-- 3. lista dei forum a cui non è iscritto l'utente -->
<p>Tutti gli altri forum: ${otherForum}</p>
</body>
</html>