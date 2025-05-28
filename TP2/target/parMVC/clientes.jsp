<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Cliente" %>
<%
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Clientes</title>
</head>
<body>
    <h1>Listado de Clientes</h1>
    <a href="ControladorClientes?accion=agregar">➕ Agregar Cliente</a>
    <br><br>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr style="background-color: #f0f0f0;">
                <th>ID</th>
                <th>Nombre</th>
                <th>Dirección</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (clientes != null && !clientes.isEmpty()) {
                for (Cliente c : clientes) {
        %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getNombre() %></td>
                <td><%= c.getDireccion() %></td>
                <td><%= c.getTelefono() %></td>
                <td>
                    <a href="ControladorClientes?accion=editar&id=<%= c.getId() %>">✏️ Editar</a> |
                    <a href="ControladorClientes?accion=eliminar&id=<%= c.getId() %>" onclick="return confirm('¿Estás seguro de eliminar este cliente?');">🗑️ Eliminar</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="5">No hay clientes registrados.</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
