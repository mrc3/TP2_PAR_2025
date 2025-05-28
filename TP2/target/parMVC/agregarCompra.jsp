<%@ page import="java.util.List" %>
<%@ page import="modelo.Producto" %>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<form action="ControladorCompras" method="post">
    <input type="hidden" name="accion" value="guardar" />
    
    Producto:
    <select name="producto">
        <%
            for (Producto p : productos) {
        %>
        <option value="<%= p.getId() %>"><%= p.getNombre() %></option>
        <%
            }
        %>
    </select><br/>

    Cantidad: <input type="number" name="cantidad"><br/>
    Precio Unitario: <input type="text" name="precio_unitario"><br/>

    <input type="submit" value="Guardar">
</form>
