
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Agregar Cliente</title></head>
<body>
<h2>Agregar Cliente</h2>
<form action="ControladorClientes" method="post">
<input type="hidden" name="accion" value="guardar" />
Nombre: <input type="text" name="nombre" /><br/>
Dirección: <input type="text" name="direccion" /><br/>
Teléfono: <input type="text" name="telefono" /><br/>
<input type="submit" value="Guardar" />
</form>
</body>
</html>
