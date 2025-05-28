package modeloDAO;

import config.Conexion;
import java.sql.*;
import java.util.*;
import modelo.Ventas;
import interfaces.InterfazVentaDAO;

public class ventaDAO implements InterfazVentaDAO {

    @Override
    public List<Ventas> listar() {
        List<Ventas> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (
            Connection con = Conexion.Conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Ventas v = new Ventas();
                v.setId(rs.getInt("id"));
                v.setProductoId(rs.getInt("producto_id"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setFecha(rs.getDate("fecha"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Ventas obtenerPorId(int id) {
        Ventas v = null;
        String sql = "SELECT * FROM ventas WHERE id = ?";
        try (
            Connection con = Conexion.Conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v = new Ventas();
                v.setId(rs.getInt("id"));
                v.setProductoId(rs.getInt("producto_id"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setFecha(rs.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener venta: " + e.getMessage());
        }
        return v;
    }

    @Override
    public boolean agregar(Ventas v) {
        String sql = "INSERT INTO ventas (producto_id, cantidad, fecha) VALUES (?, ?, ?)";
        try (
            Connection con = Conexion.Conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, v.getProductoId());
            ps.setInt(2, v.getCantidad());
            ps.setDate(3, new java.sql.Date(v.getFecha().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar venta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean editar(Ventas v) {
        String sql = "UPDATE ventas SET producto_id = ?, cantidad = ?, fecha = ? WHERE id = ?";
        try (
            Connection con = Conexion.Conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, v.getProductoId());
            ps.setInt(2, v.getCantidad());
            ps.setDate(3, new java.sql.Date(v.getFecha().getTime()));
            ps.setInt(4, v.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al editar venta: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM ventas WHERE id = ?";
        try (
            Connection con = Conexion.Conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
            return false;
        }
    }
}
