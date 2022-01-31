<%@page import="it.musei.presentation.TransferMuseo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cerca museo per ID</title>
</head>
<!-- recuperiamo i parametri -->
<%
TransferMuseo tm = (TransferMuseo) request.getAttribute("transfermuseo");

boolean firstTime = tm == null;
%>
<body>
	<%
	if (!firstTime && !tm.isSuccess()) {
	%>
	<div style="background: red; padding: 15px;">
		<%=tm.getMessage()%>

	</div>
	<%
	}
	%>
	<h2>Cerca per ID museo</h2>
	<br>
	<form method="get" action="/musei/trovamuseo">
		<br> <input type="text" name="id_museo"><br> <input
			type="submit" value="invia">
		<%
		if (!firstTime && tm.isSuccess()) {
		%>
		<div style="background: green; padding: 15px;">
			<h3>Dati Museo</h3>
			<p>
				Nome:
				<%=tm.getMuseo().getNome()%></p>
			<p>
				Citta:
				<%=tm.getMuseo().getCitta()%></p>
		</div>
		<%
		}
		%>
	</form>
</body>
</html>