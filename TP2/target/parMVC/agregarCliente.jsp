<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Cliente</title>
</head>
<body>
    <h1>Agregar Nuevo Cliente</h1>
    <form action="ControladorClientes" method="post">
        <input type="hidden" name="accion" value="guardar">
        <label>Nombre:</label><br>
        <input type="text" name="nombre" required><br><br>

        <label>Dirección:</label><br>
        <input type="text" name="direccion" required><br><br>

        <label>Teléfono:</label><br>
        <input type="text" name="telefono" required><br><br>

        <input type="submit" value="Guardar">
        <a href="ControladorClientes">Cancelar</a>
    </form>
</body>
</html>
