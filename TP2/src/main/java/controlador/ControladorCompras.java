package controlador;

import modelo.Compra;
import modelo.Producto;
import modeloDAO.CompraDAO;
import modeloDAO.ProductoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ControladorCompras extends HttpServlet {

    CompraDAO dao = new CompraDAO();
    ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("compras", dao.listar());
            request.getRequestDispatcher("compras.jsp").forward(request, response);
        } else if (accion.equals("agregar")) {
            List<Producto> productos = productoDAO.getProductos();
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("agregarCompra.jsp").forward(request, response);
        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Compra compra = dao.obtenerPorId(id);
            List<Producto> productos = productoDAO.getProductos();
            request.setAttribute("compra", compra);
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("editarCompra.jsp").forward(request, response);
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("ControladorCompras");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            Compra c = new Compra();
            c.setProducto(request.getParameter("producto"));
            c.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            c.setPrecioUnitario(Double.parseDouble(request.getParameter("precio_unitario")));
            c.setFecha(new Date()); // Corregido: poner la fecha actual
            dao.agregar(c);

        } else if ("actualizar".equals(accion)) {
            Compra c = new Compra();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setProducto(request.getParameter("producto"));
            c.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            c.setPrecioUnitario(Double.parseDouble(request.getParameter("precio_unitario")));
            c.setFecha(new Date()); // O usar la fecha pasada si tenés un input
            dao.editar(c);
        }

        response.sendRedirect("ControladorCompras");
    }
}
