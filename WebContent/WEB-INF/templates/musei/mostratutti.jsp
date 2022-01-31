<%@page import="it.musei.entity.Dipinto"%>
<%@page import="it.musei.entity.Museo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Musei</title>
</head>
<body style="text-align: center; background-color: lightblue;">
	<h1>Lista di tutti i musei</h1>

	<%
	List<Museo> listaMusei = (List) request.getAttribute("lista");
	%>

	<%
	for (Museo m : listaMusei) {
	%>
	<table style="border: 1px solid yellow;">
		<tr>
			<th>ID museo</th>
			<th>Nome museo</th>
			<th>Città museo</th>
		</tr>
		<tr>
			<td><%=m.getIdMuseo()%></td>
			<td><%=m.getNome()%></td>
			<td><%=m.getCitta()%></td>
		</tr>
	</table>
	<%}%>
</body>
</html>