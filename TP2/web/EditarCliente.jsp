
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente" %>
<jsp:useBean id="cliente" scope="request" type="modelo.Cliente" />
<html>
<head><title>Editar Cliente</title></head>
<body>
<h2>Editar Cliente</h2>
<form action="ControladorClientes" method="post">
<input type="hidden" name="accion" value="actualizar" />
<input type="hidden" name="id" value="<%= cliente.getId() %>" />
Nombre: <input type="text" name="nombre" value="<%= cliente.getNombre() %>" /><br/>
Dirección: <input type="text" name="direccion" value="<%= cliente.getDireccion() %>" /><br/>
Teléfono: <input type="text" name="telefono" value="<%= cliente.getTelefono() %>" /><br/>
<input type="submit" value="Actualizar" />
</form>
</body>
</html>
