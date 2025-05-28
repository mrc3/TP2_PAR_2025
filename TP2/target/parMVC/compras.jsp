<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Compra" %>
<%
    List<Compra> compras = (List<Compra>) request.getAttribute("compras");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Compras</title>
</head>
<body>
    <h1>Listado de Compras</h1>
    <a href="ControladorCompras?accion=agregar">Agregar Compra</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio Unitario</th>
            <th>Fecha</th>
            <th>Acciones</th>
        </tr>
        <%
            if (compras != null) {
                for (Compra c : compras) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getProducto() %></td>
            <td><%= c.getCantidad() %></td>
            <td><%= c.getPrecioUnitario() %></td>
            <td><%= c.getFecha() %></td>
            <td>
                <a href="ControladorCompras?accion=editar&id=<%= c.getId() %>">Editar</a>
                <a href="ControladorCompras?accion=eliminar&id=<%= c.getId() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
