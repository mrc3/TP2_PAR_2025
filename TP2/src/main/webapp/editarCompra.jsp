<%@ page import="java.util.List" %>
<%@ page import="modelo.Producto" %>
<%@ page import="modelo.Compra" %>
<%
    Compra compra = (Compra) request.getAttribute("compra");
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Compra</title>
</head>
<body>
    <h1>Editar Compra</h1>
    <form action="ControladorCompras" method="post">
        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="id" value="<%= compra.getId() %>">

        Producto:
        <select name="producto">
            <% for (Producto p : productos) { %>
                <option value="<%= p.getId() %>" <%= (p.getId() == Integer.parseInt(compra.getProducto()) ? "selected" : "") %>>
                    <%= p.getNombre() %>
                </option>
            <% } %>
        </select><br>

        Cantidad: <input type="number" name="cantidad" value="<%= compra.getCantidad() %>"><br>
        Precio Unitario: <input type="text" name="precio_unitario" value="<%= compra.getPrecioUnitario() %>"><br>

        <input type="submit" value="Actualizar">
    </form>
    <br>
    <a href="ControladorCompras">Volver al listado</a>
</body>
</html>
