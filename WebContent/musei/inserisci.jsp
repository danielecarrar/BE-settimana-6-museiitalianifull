<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Musei</title>
</head>
<body>
	<h1>Inserimento dei musei</h1>
	<form method="post" action="/musei/inserisciservlet" >
		Nome: <input type="text" name="nome_museo"><br>
		Città: <input type="text" name="citta_museo"><br>
		<input type="hidden" name="dominio" value="musei">
		<input type="submit" value="inserisci">
	</form>
</body>
</html>