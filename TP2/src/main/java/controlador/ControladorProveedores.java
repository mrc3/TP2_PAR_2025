package controlador;

import modelo.Proveedor;
import modeloDAO.ProveedorDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ControladorProveedores extends HttpServlet {

    ProveedorDAO dao = new ProveedorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("proveedores", dao.listar());
            request.getRequestDispatcher("proveedores.jsp").forward(request, response);

        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Proveedor proveedor = dao.obtenerPorId(id);
            request.setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("editarProveedor.jsp").forward(request, response);

        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("ControladorProveedores");

        } else if (accion.equals("agregar")) {
            request.getRequestDispatcher("agregarProveedor.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            Proveedor p = new Proveedor();
            p.setNombre(request.getParameter("nombre"));
            p.setDireccion(request.getParameter("direccion"));
            p.setTelefono(request.getParameter("telefono"));
            dao.agregar(p);

        } else if ("actualizar".equals(accion)) {
            Proveedor p = new Proveedor();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNombre(request.getParameter("nombre"));
            p.setDireccion(request.getParameter("direccion"));
            p.setTelefono(request.getParameter("telefono"));
            dao.editar(p);
        }

        response.sendRedirect("ControladorProveedores");
    }
}
