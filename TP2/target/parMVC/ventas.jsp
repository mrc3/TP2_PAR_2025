<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ventas" %>
<%
    List<Ventas> ventas = (List<Ventas>) request.getAttribute("ventas");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Ventas</title>
</head>
<body>
    <h1>Listado de Ventas</h1>
    <a href="ControladorVentas?accion=agregar">Agregar Venta</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>ID Producto</th>
            <th>Cantidad</th>
            <th>Fecha</th>
            <th>Acciones</th>
        </tr>
        <%
            if (ventas != null) {
                for (Ventas v : ventas) {
        %>
        <tr>
            <td><%= v.getId() %></td>
            <td><%= v.getProductoId() %></td>
            <td><%= v.getCantidad() %></td>
            <td><%= v.getFecha() %></td>
            <td>
                <a href="ControladorVentas?accion=editar&id=<%= v.getId() %>">Editar</a>
                <a href="ControladorVentas?accion=eliminar&id=<%= v.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>