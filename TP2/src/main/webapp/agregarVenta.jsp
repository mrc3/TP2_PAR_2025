<%@ page import="java.util.List" %>
<%@ page import="modelo.Producto" %>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Nueva Venta</title>
</head>
<body>
    <h1>Agregar Nueva Venta</h1>
    <form action="ControladorVentas" method="post">
        <input type="hidden" name="accion" value="guardar">
        <label>Producto:</label>
        <select name="producto">
            <%
                for (Producto p : productos) {
            %>
                <option value="<%= p.getId() %>"><%= p.getNombre() %></option>
            <%
                }
            %>
        </select><br>
        <label>Cantidad:</label>
        <input type="number" name="cantidad" required><br>
        <button type="submit">Guardar</button>
    </form>
    <a href="ControladorVentas">Volver al listado</a>
</body>
</html>
