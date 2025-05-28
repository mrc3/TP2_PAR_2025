package modeloDAO;

import config.Conexion;
import modelo.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todos los proveedores
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Obtener proveedor por ID
    public Proveedor obtenerPorId(int id) {
        Proveedor p = new Proveedor();
        String sql = "SELECT * FROM proveedores WHERE id = ?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    // Agregar nuevo proveedor
    public boolean agregar(Proveedor p) {
        String sql = "INSERT INTO proveedores (nombre, direccion, telefono) VALUES (?, ?, ?)";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Editar proveedor
    public boolean editar(Proveedor p) {
        String sql = "UPDATE proveedores SET nombre=?, direccion=?, telefono=? WHERE id=?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar proveedor
    public void eliminar(int id) {
        String sql = "DELETE FROM proveedores WHERE id=?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
