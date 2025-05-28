package controlador;

import java.io.IOException;
import modelo.Cliente;
import modeloDAO.ClienteDAO;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * ControladorClientes es un servlet que maneja las operaciones CRUD para la entidad Cliente.
 * Permite listar, agregar, editar y eliminar clientes a través de solicitudes HTTP.
 * package controlador;
 */

public class ControladorClientes extends HttpServlet {
    
    ClienteDAO dao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("clientes", dao.listar());
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = dao.obtenerPorId(id);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
        
        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("ControladorClientes");
        
        } else if (accion.equals("agregar")) {
            request.getRequestDispatcher("agregarCliente.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            Cliente c = new Cliente();
            c.setNombre(request.getParameter("nombre"));
            c.setDireccion(request.getParameter("direccion"));
            c.setTelefono(request.getParameter("telefono"));
            dao.agregar(c);

        } else if ("actualizar".equals(accion)) {
            Cliente c = new Cliente();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNombre(request.getParameter("nombre"));
            c.setDireccion(request.getParameter("direccion"));
            c.setTelefono(request.getParameter("telefono"));
            dao.editar(c);
        }

        response.sendRedirect("ControladorClientes");
    }
}
