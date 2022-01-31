<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipinti</title>
</head>
<body>
	<h1>Inserimento dei musei</h1>
	<form method="post" action="/musei/inserisciservlet" >
		Titolo: <input type="text" name="titolo"><br>
		Anno: <input type="text" name="anno"><br>
		<input type="hidden" name="dominio" value="dipinti">
		<input type="submit" value="inserisci">
	</form>
</body>
</html>