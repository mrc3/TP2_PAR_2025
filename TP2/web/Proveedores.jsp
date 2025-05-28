
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,modelo.Proveedores" %>
<jsp:useBean id="proveedoress" scope="request" type="java.util.List" />
<html>
<head><title>Proveedores</title></head>
<body>
<h2>Lista de Proveedores</h2>
<table border="1">
<tr><th>Id</th><th>Nombre</th><th>Direccion</th><th>Telefono</th><th>Acciones</th></tr>
<% for (Proveedores obj : proveedoress) { %>
<tr>
<td><%= obj.getId() %></td><td><%= obj.getNombre() %></td><td><%= obj.getDireccion() %></td><td><%= obj.getTelefono() %></td>
<td><a href="#">Editar</a> | <a href="#">Eliminar</a></td>
</tr>
<% } %>
</table>
</body>
</html>
