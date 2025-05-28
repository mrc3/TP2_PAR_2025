package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Compra;

public class CompraDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todas las compras
    public List<Compra> listar() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM compras";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt("id"));
                c.setProducto(rs.getString("producto"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setPrecioUnitario(rs.getDouble("precio_unitario"));
                c.setFecha(rs.getDate("fecha"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar compras: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
        return lista;
    }

    // Agregar una nueva compra
    public boolean agregar(Compra c) {
        String sql = "INSERT INTO compras (producto, cantidad, precio_unitario, fecha) VALUES (?, ?, ?, ?)";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getProducto());
            ps.setInt(2, c.getCantidad());
            ps.setDouble(3, c.getPrecioUnitario());
            ps.setDate(4, new java.sql.Date(c.getFecha().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar compra: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
        return false;
    }

    // Obtener compra por ID
    public Compra obtenerPorId(int id) {
        Compra c = new Compra();
        String sql = "SELECT * FROM compras WHERE id = ?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setProducto(rs.getString("producto"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setPrecioUnitario(rs.getDouble("precio_unitario"));
                c.setFecha(rs.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener compra por ID: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
        return c;
    }

    // Actualizar compra
    public boolean editar(Compra c) {
        String sql = "UPDATE compras SET producto = ?, cantidad = ?, precio_unitario = ?, fecha = ? WHERE id = ?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getProducto());
            ps.setInt(2, c.getCantidad());
            ps.setDouble(3, c.getPrecioUnitario());
            ps.setDate(4, new java.sql.Date(c.getFecha().getTime()));
            ps.setInt(5, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al editar compra: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
        return false;
    }

    // Eliminar compra
    public boolean eliminar(int id) {
        String sql = "DELETE FROM compras WHERE id = ?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar compra: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
        return false;
    }
}
