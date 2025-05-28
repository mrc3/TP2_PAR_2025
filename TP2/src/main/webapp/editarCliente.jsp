<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente" %>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
</head>
<body>
    <h1>Editar Cliente</h1>
    <form action="ControladorClientes" method="post">
        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="id" value="<%= cliente.getId() %>">

        <label>Nombre:</label><br>
        <input type="text" name="nombre" value="<%= cliente.getNombre() %>" required><br><br>

        <label>Dirección:</label><br>
        <input type="text" name="direccion" value="<%= cliente.getDireccion() %>" required><br><br>

        <label>Teléfono:</label><br>
        <input type="text" name="telefono" value="<%= cliente.getTelefono() %>" required><br><br>

        <input type="submit" value="Actualizar">
        <a href="ControladorClientes">Cancelar</a>
    </form>
</body>
</html>
