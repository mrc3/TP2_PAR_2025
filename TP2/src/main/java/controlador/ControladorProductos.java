package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Auditoria;
import modelo.Producto;
import modelo.Usuario;
import modeloDAO.AuditoriaDAO;
import modeloDAO.ProductoDAO;

public class ControladorProductos extends HttpServlet {

    ProductoDAO DaoProducto;

    private List<Producto> FiltarPorCategoria(List<Producto> productos, String categoriaAFiltrar) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (Objects.equals(producto.getCategoria(), categoriaAFiltrar)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        List<Producto> productos = new ArrayList<>();
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");
        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        DaoProducto = new ProductoDAO();

        switch (accion) {
            case "listar":
                productos = DaoProducto.getProductos();
                Collections.reverse(productos);
                String categoriaAFiltrar = request.getParameter("txtCategoria");
                if (Objects.equals(categoriaAFiltrar, "Todos") || categoriaAFiltrar == null) {
                    request.setAttribute("Productos", productos);
                } else {
                    productos = FiltarPorCategoria(productos, categoriaAFiltrar);
                    request.setAttribute("Productos", productos);
                }
                request.getRequestDispatcher("listadoProductos.jsp").forward(request, response);
                break;

            case "nuevo":
                request.getRequestDispatcher("addProducto.jsp").forward(request, response);
                break;

            case "Agregar":
                try {
                    String nombre = request.getParameter("txtNombre");
                    String descripcion = request.getParameter("txtDescripcion");
                    Integer unidades = Integer.valueOf(request.getParameter("txtUnidades").trim());
                    Double costo = Double.valueOf(request.getParameter("txtCosto").trim());
                    Double precio = Double.valueOf(request.getParameter("txtPrecio").trim());
                    String categoria = request.getParameter("txtCategoria");

                    Producto producto = new Producto(nombre, descripcion, unidades, costo, precio, categoria);
                    int resultado = DaoProducto.add(producto);

                    if (resultado != 0) {
                        Auditoria registro = new Auditoria(nombre, descripcion, unidades, costo, precio, categoria, idUsuario, nombreUsuario, "Agregó");
                        new AuditoriaDAO().agregarRegistro(registro);
                        request.setAttribute("config", "alert alert-success");
                        request.setAttribute("mensaje", "EL PRODUCTO SE HA AGREGADO CON ÉXITO");
                    } else {
                        request.setAttribute("config", "alert alert-danger");
                        request.setAttribute("mensaje", "NO SE HA PODIDO GUARDAR EL PRODUCTO");
                    }
                } catch (Exception e) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL AGREGAR PRODUCTO: " + e.getMessage());
                }
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                break;

            case "Editar":
                int id = Integer.parseInt(request.getParameter("id"));
                Producto p = DaoProducto.getId(id);
                request.setAttribute("producto", p);
                request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
                break;

            case "Actualizar":
                try {
                    int idProducto = Integer.parseInt(request.getParameter("txtId"));
                    Producto productoAEditar = DaoProducto.getId(idProducto);

                    String nombre1 = request.getParameter("txtNombre");
                    String descripcion1 = request.getParameter("txtDescripcion");
                    Integer unidades1 = Integer.parseInt(request.getParameter("txtUnidades").trim());
                    Double costo1 = Double.parseDouble(request.getParameter("txtCosto").trim());
                    Double precio1 = Double.parseDouble(request.getParameter("txtPrecio").trim());
                    String categoria1 = request.getParameter("txtCategoria");

                    Producto productoEditado = new Producto(idProducto, nombre1, descripcion1, unidades1, costo1, precio1, categoria1);
                    int respuesta = DaoProducto.update(productoEditado);

                    AuditoriaDAO DaoAuditoria = new AuditoriaDAO();

                    if (respuesta != 0) {
                        Auditoria registroAnterior = new Auditoria(productoAEditar.getNombre(), productoAEditar.getDescripcion(), productoAEditar.getUnidades(), productoAEditar.getCosto(), productoAEditar.getPrecio(), productoAEditar.getCategoria(), idUsuario, nombreUsuario, "Estado anterior");
                        DaoAuditoria.agregarRegistro(registroAnterior);

                        Auditoria registro = new Auditoria(nombre1, descripcion1, unidades1, costo1, precio1, categoria1, idUsuario, nombreUsuario, "Actualizó");
                        DaoAuditoria.agregarRegistro(registro);

                        request.setAttribute("config", "alert alert-success");
                        request.setAttribute("mensaje", "EL PRODUCTO SE HA ACTUALIZADO CON ÉXITO");
                    } else {
                        request.setAttribute("config", "alert alert-danger");
                        request.setAttribute("mensaje", "NO SE HA PODIDO ACTUALIZAR EL PRODUCTO");
                    }

                } catch (NumberFormatException e) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR DE FORMATO NUMÉRICO: Verifique los campos numéricos.");
                } catch (Exception ex) {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "OCURRIÓ UN ERROR INESPERADO: " + ex.getMessage());
                }
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                break;

            case "Delete":
                int idProd = Integer.valueOf(request.getParameter("id"));
                Producto productoABorrar = DaoProducto.getId(idProd);
                int res = DaoProducto.delete(idProd);
                if (res != 0) {
                    Auditoria registro = new Auditoria(productoABorrar.getNombre(), productoABorrar.getDescripcion(), productoABorrar.getUnidades(), productoABorrar.getCosto(), productoABorrar.getPrecio(), productoABorrar.getCategoria(), idUsuario, nombreUsuario, "Borró");
                    new AuditoriaDAO().agregarRegistro(registro);
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "EL PRODUCTO SE HA ELIMINADO CON ÉXITO");
                } else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "NO SE HA PODIDO ELIMINAR EL PRODUCTO");
                }
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                break;

            default:
                throw new AssertionError("Acción no reconocida: " + accion);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador de Productos con validación segura";
    }
}
