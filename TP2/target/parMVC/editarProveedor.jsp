<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Proveedor" %>
<%
    Proveedor p = (Proveedor) request.getAttribute("proveedor");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Proveedor</title>
</head>
<body>
    <h1>Editar Proveedor</h1>
    <form action="ControladorProveedores" method="post">
        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="id" value="<%= p.getId() %>">
        <label>Nombre:</label><br>
        <input type="text" name="nombre" value="<%= p.getNombre() %>" required><br><br>
        <label>Dirección:</label><br>
        <input type="text" name="direccion" value="<%= p.getDireccion() %>" required><br><br>
        <label>Teléfono:</label><br>
        <input type="text" name="telefono" value="<%= p.getTelefono() %>" required><br><br>
        <input type="submit" value="Actualizar">
        <a href="ControladorProveedores">Cancelar</a>
    </form>
</body>
</html>
