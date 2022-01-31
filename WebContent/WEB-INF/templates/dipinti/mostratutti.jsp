<%@page import="java.util.List"%>
<%@page import="it.musei.entity.Dipinto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipinti</title>
</head>
<body style="text-align: center; background-color: lightblue;">
<h1>Lista di tutti i dipinti</h1>

<%List<Dipinto> listaDipinti = (List) request.getAttribute("lista");%>

	<%for (Dipinto d : listaDipinti) {%>
	<table style="border: 1px solid green;">
		<tr>
			<th>ID dipinto</th>
			<th>Titolo</th>
			<th>Anno</th>
		</tr>
		<tr>
			<td><%=d.getIdDipinto()%></td>
			<td><%=d.getTitolo()%></td>
			<td><%=d.getAnnoDipinto()%></td>
		</tr>
	</table>
	<%}%>
</body>
</html>