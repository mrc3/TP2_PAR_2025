
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,modelo.Cliente" %>
<jsp:useBean id="clientes" scope="request" type="java.util.List" />
<html>
<head><title>Clientes</title></head>
<body>
<h2>Lista de Clientes</h2>
<a href="ControladorClientes?accion=agregar">Agregar Cliente</a>
<table border="1">
<tr><th>ID</th><th>Nombre</th><th>Dirección</th><th>Teléfono</th><th>Acciones</th></tr>
<% for (Cliente c : clientes) { %>
<tr>
<td><%= c.getId() %></td>
<td><%= c.getNombre() %></td>
<td><%= c.getDireccion() %></td>
<td><%= c.getTelefono() %></td>
<td>
<a href="ControladorClientes?accion=editar&id=<%= c.getId() %>">Editar</a> |
<a href="ControladorClientes?accion=eliminar&id=<%= c.getId() %>">Eliminar</a>
</td>
</tr>
<% } %>
</table>
</body>
</html>
