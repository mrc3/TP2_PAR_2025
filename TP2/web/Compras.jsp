
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,modelo.Compras" %>
<jsp:useBean id="comprass" scope="request" type="java.util.List" />
<html>
<head><title>Compras</title></head>
<body>
<h2>Lista de Compras</h2>
<table border="1">
<tr><th>Id</th><th>Producto_id</th><th>Cantidad</th><th>Fecha</th><th>Acciones</th></tr>
<% for (Compras obj : comprass) { %>
<tr>
<td><%= obj.getId() %></td><td><%= obj.getProducto_id() %></td><td><%= obj.getCantidad() %></td><td><%= obj.getFecha() %></td>
<td><a href="#">Editar</a> | <a href="#">Eliminar</a></td>
</tr>
<% } %>
</table>
</body>
</html>
