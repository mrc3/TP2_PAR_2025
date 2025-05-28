package modeloDAO;

import java.sql.*;
import java.util.*;
import config.Conexion;
import modelo.Cliente;
import interfaces.InterfazClienteDAO;

public class ClienteDAO implements InterfazClienteDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cliente obtenerPorId(int id) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM clientes WHERE id=?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public boolean agregar(Cliente c) {
        String sql = "INSERT INTO clientes(nombre, direccion, telefono) VALUES (?, ?, ?)";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editar(Cliente c) {
        String sql = "UPDATE clientes SET nombre=?, direccion=?, telefono=? WHERE id=?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try {
            con = Conexion.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
