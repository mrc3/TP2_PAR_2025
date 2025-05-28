
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,modelo.Ventas" %>
<jsp:useBean id="ventass" scope="request" type="java.util.List" />
<html>
<head><title>Ventas</title></head>
<body>
<h2>Lista de Ventas</h2>
<table border="1">
<tr><th>Id</th><th>Producto_id</th><th>Cantidad</th><th>Fecha</th><th>Acciones</th></tr>
<% for (Ventas obj : ventass) { %>
<tr>
<td><%= obj.getId() %></td><td><%= obj.getProducto_id() %></td><td><%= obj.getCantidad() %></td><td><%= obj.getFecha() %></td>
<td><a href="#">Editar</a> | <a href="#">Eliminar</a></td>
</tr>
<% } %>
</table>
</body>
</html>
