
import modelo.*;
import modeloDAO.*;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DAOTests {

    ClienteDAO clienteDAO = new ClienteDAO();
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    ProductoDAO productoDAO = new ProductoDAO();
    CompraDAO compraDAO = new CompraDAO();
    ventaDAO ventaDAO = new ventaDAO();

    @Test
    public void testClienteDAO() {
        Cliente c = new Cliente();
        c.setNombre("Test Cliente");
        c.setDireccion("Test Direccion");
        c.setTelefono("123456");

        clienteDAO.agregar(c);
        List<Cliente> lista = clienteDAO.listar();
        assertNotNull(lista);
        assertTrue(lista.stream().anyMatch(cliente -> cliente.getNombre().equals("Test Cliente")));

        Cliente added = lista.stream().filter(cliente -> cliente.getNombre().equals("Test Cliente")).findFirst().orElse(null);
        assertNotNull(added);

        clienteDAO.eliminar(added.getId());
        lista = clienteDAO.listar();
        assertFalse(lista.stream().anyMatch(cliente -> cliente.getNombre().equals("Test Cliente")));
    }

    @Test
    public void testProveedorDAO() {
        Proveedor p = new Proveedor();
        p.setNombre("Test Proveedor");
        p.setDireccion("Test Direccion");
        p.setTelefono("123456");

        proveedorDAO.agregar(p);
        List<Proveedor> lista = proveedorDAO.listar();
        assertNotNull(lista);
        assertTrue(lista.stream().anyMatch(prov -> prov.getNombre().equals("Test Proveedor")));

        Proveedor added = lista.stream().filter(prov -> prov.getNombre().equals("Test Proveedor")).findFirst().orElse(null);
        assertNotNull(added);

        proveedorDAO.eliminar(added.getId());
        lista = proveedorDAO.listar();
        assertFalse(lista.stream().anyMatch(prov -> prov.getNombre().equals("Test Proveedor")));
    }

    @Test
    public void testProductoDAO() {
        Producto p = new Producto();
        p.setNombre("Test Producto");
        p.setPrecio(1000);
        p.setStock(10);

        productoDAO.agregar(p);
        List<Producto> lista = productoDAO.listar();
        assertNotNull(lista);
        assertTrue(lista.stream().anyMatch(prod -> prod.getNombre().equals("Test Producto")));

        Producto added = lista.stream().filter(prod -> prod.getNombre().equals("Test Producto")).findFirst().orElse(null);
        assertNotNull(added);

        productoDAO.eliminar(added.getId());
        lista = productoDAO.listar();
        assertFalse(lista.stream().anyMatch(prod -> prod.getNombre().equals("Test Producto")));
    }

    @Test
    public void testCompraDAO() {
        Compra c = new Compra();
        c.setProducto("Test Producto Compra");
        c.setCantidad(5);
        c.setPrecioUnitario(1500.0);
        c.setFecha(new Date());

        compraDAO.agregar(c);
        List<Compra> lista = compraDAO.listar();
        assertNotNull(lista);
        assertTrue(lista.stream().anyMatch(comp -> "Test Producto Compra".equals(comp.getProducto())));
    }

    @Test
    public void testVentaDAO() {
        Ventas v = new Ventas();
        v.setProductoId(1); // Asegúrate de que este ID existe en tu base de datos
        v.setCantidad(3);
        v.setFecha(new java.sql.Date(System.currentTimeMillis()));

        ventaDAO.agregar(v);
        List<Ventas> lista = ventaDAO.listar();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }
}
