package controlador;

import modelo.Ventas;
import modelo.Producto;
import modeloDAO.ventaDAO;
import modeloDAO.ProductoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ControladorVentas extends HttpServlet {
    ventaDAO dao = new ventaDAO();
    ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("ventas", dao.listar());
            request.getRequestDispatcher("ventas.jsp").forward(request, response);

        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Ventas venta = dao.obtenerPorId(id);
            request.setAttribute("venta", venta);
            List<Producto> productos = productoDAO.getProductos();
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("editarVenta.jsp").forward(request, response);

        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("ControladorVentas");

        } else if (accion.equals("agregar")) {
            List<Producto> productos = productoDAO.getProductos();
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("agregarVenta.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            Ventas v = new Ventas();
            int idProducto = Integer.parseInt(request.getParameter("producto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            v.setProductoId(idProducto);
            v.setCantidad(cantidad);
            v.setFecha(new java.sql.Date(System.currentTimeMillis()));
            dao.agregar(v);
            productoDAO.restarStock(idProducto, cantidad); // Resta del stock

        } else if ("actualizar".equals(accion)) {
            Ventas v = new Ventas();
            v.setId(Integer.parseInt(request.getParameter("id")));
            v.setProductoId(Integer.parseInt(request.getParameter("producto")));
            v.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            v.setFecha(java.sql.Date.valueOf(request.getParameter("fecha")));
            dao.editar(v);
        }

        response.sendRedirect("ControladorVentas");
    }
}
