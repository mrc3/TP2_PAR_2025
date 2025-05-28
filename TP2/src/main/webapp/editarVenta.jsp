<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Venta" %>
<%
    Venta venta = (Venta) request.getAttribute("venta");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Venta</title>
</head>
<body>
    <h1>Editar Venta</h1>
    <form action="ControladorVentas" method="POST">
        <label for="producto">Producto:</label>
        <input type="text" name="producto" value="<%= venta.getProducto() %>" required><br><br>

        <label for="cantidad">Cantidad:</label>
        <input type="number" name="cantidad" value="<%= venta.getCantidad() %>" required><br><br>

        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha" value="<%= venta.getFecha() %>" required><br><br>

        <input type="hidden" name="id" value="<%= venta.getId() %>">
        <input type="hidden" name="accion" value="actualizar">
        <input type="submit" value="Actualizar">
    </form>
    <br>
    <a href="ControladorVentas?accion=listar">Volver al listado</a>
</body>
</html>
