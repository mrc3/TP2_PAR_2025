<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión - Editar producto</title>
    <link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario) sesion.getAttribute("usuarioLogueado");

    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<div class="container mt-4">
    <form action="Controlador" method="POST">
        <div class="card border-info mb-4" style="max-width: 600px; margin: auto;">
            <div class="card-header">
                ACTUALIZAR PRODUCTO
            </div>

            <div class="card-body text-info">
                <div class="form-group mb-2">
                    <label>ID</label>
                    <input type="text" value="${producto.id}" name="txtId" readonly class="form-control">
                </div>

                <div class="form-group mb-2">
                    <label>NOMBRE</label>
                    <input type="text" value="${producto.nombre}" name="txtNombre" class="form-control" required>
                </div>

                <div class="form-group mb-2">
                    <label>DESCRIPCIÓN</label>
                    <input type="text" value="${producto.descripcion}" name="txtDescripcion" class="form-control" required>
                </div>

                <div class="form-group mb-2">
                    <label>UNIDADES</label>
                    <input type="number" value="${producto.unidades}" name="txtUnidades" class="form-control" required min="0">
                </div>

                <div class="form-group mb-2">
                    <label>COSTO</label>
                    <input type="number" step="0.01" value="${producto.costo}" name="txtCosto" class="form-control" required min="0">
                </div>

                <div class="form-group mb-2">
                    <label>PRECIO</label>
                    <input type="number" step="0.01" value="${producto.precio}" name="txtPrecio" class="form-control" required min="0">
                </div>

                <div class="form-group mb-2">
                    <label>CATEGORÍA</label>
                    <select name="txtCategoria" class="form-control" required>
                        <option value="">Seleccione una categoría</option>
                        <option value="Alimentos" ${producto.categoria == 'Alimentos' ? 'selected' : ''}>Alimentos</option>
                        <option value="Bebidas" ${producto.categoria == 'Bebidas' ? 'selected' : ''}>Bebidas</option>
                        <option value="Limpieza" ${producto.categoria == 'Limpieza' ? 'selected' : ''}>Limpieza</option>
                    </select>
                </div>
            </div>

            <div class="card-footer">
                <input type="submit" value="Actualizar" name="accion" class="btn btn-outline-success">
                <a href="Controlador?accion=listar" class="btn btn-link">Volver</a>
            </div>
        </div>
    </form>
</div>

<script src="./Bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>
