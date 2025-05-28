<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,modelo.Movimientos" %>
<jsp:useBean id="movimientoss" scope="request" type="java.util.List" />
<html>
<head><title>Reporte de Movimientos Financieros</title></head>
<body>
<h2>Reporte de Movimientos Financieros</h2>
<table border="1">
<tr><th>ID</th><th>Tipo</th><th>Producto</th><th>Cantidad</th><th>Fecha</th></tr>
<% for (Movimientos obj : movimientoss) { %>
<tr>
<td><%= obj.getId() %></td>
<td><%= obj.getTipo() %></td>
<td><%= obj.getProducto() %></td>
<td><%= obj.getCantidad() %></td>
<td><%= obj.getFecha() %></td>
</tr>
<% }} %>
</table>
</body>
</html>