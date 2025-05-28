<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Proveedor" %>
<%
    List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Proveedores</title>
</head>
<body>
    <h1>Listado de Proveedores</h1>
    <a href="ControladorProveedores?accion=agregar">Agregar Proveedor</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Teléfono</th>
            <th>Acciones</th>
        </tr>
        <%
            if (proveedores != null) {
                for (Proveedor p : proveedores) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getDireccion() %></td>
            <td><%= p.getTelefono() %></td>
            <td>
                <a href="ControladorProveedores?accion=editar&id=<%= p.getId() %>">Editar</a>
                <a href="ControladorProveedores?accion=eliminar&id=<%= p.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
