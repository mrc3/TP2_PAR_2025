<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,modelo.Inventario" %>
<jsp:useBean id="inventarios" scope="request" type="java.util.List" />
<html>
<head><title>Reporte de Inventario</title></head>
<body>
<h2>Reporte de Inventario</h2>
<table border="1">
<tr><th>ID</th><th>Nombre</th><th>Cantidad en Stock</th></tr>
<% for (Inventario obj : inventarios) { %>
<tr>
<td><%= obj.getId() %></td>
<td><%= obj.getNombre() %></td>
<td><%= obj.getStock() %></td>
</tr>
<% }} %>
</table>
</body>
</html>