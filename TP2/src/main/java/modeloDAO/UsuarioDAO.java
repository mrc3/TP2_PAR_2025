package modeloDAO;

import config.Conexion;
import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import interfaces.InterfazUsuarioDAO;

public class UsuarioDAO implements InterfazUsuarioDAO {

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasenia(rs.getString("password"));
                usuario.setAdministrador(rs.getInt("administrador"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }

        Conexion.cerrarConexion();
        return usuarios;
    }

    @Override
    public Usuario getUsuario(String nombre) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ?;";
        Usuario usuario = new Usuario();
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasenia(rs.getString("password"));
                usuario.setAdministrador(rs.getInt("administrador"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }

        Conexion.cerrarConexion();
        return usuario;
    }

    @Override
    public Usuario getUsuario(String nombre, String contrasenia) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?;";
        Usuario usuario = new Usuario();
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasenia(rs.getString("password"));
                usuario.setAdministrador(rs.getInt("administrador"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }

        Conexion.cerrarConexion();
        return usuario;
    }

    @Override
    public Usuario getId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?;";
        Usuario usuario = new Usuario();
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContrasenia(rs.getString("password"));
                usuario.setAdministrador(rs.getInt("administrador"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }

        Conexion.cerrarConexion();
        return usuario;
    }

    @Override
    public int add(Usuario usuario) {
        int resultado = 0;
        String sql = "INSERT INTO usuarios(nombre, password, administrador) VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenia());
            ps.setInt(3, usuario.getAdministrador());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar en la base de datos: " + e);
        }

        Conexion.cerrarConexion();
        return resultado;
    }

    @Override
    public int update(Usuario usuario) {
        int resultado = 0;
        String sql = "UPDATE usuarios SET nombre = ?, password = ?, administrador = ? WHERE id = ?;";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenia());
            ps.setInt(3, usuario.getAdministrador());
            ps.setInt(4, usuario.getId());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar en la base de datos: " + e);
        }

        Conexion.cerrarConexion();
        return resultado;
    }

    @Override
    public int delete(int id) {
        int resultado = 0;
        String sql = "DELETE FROM usuarios WHERE id = ?;";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar en la base de datos: " + e);
        }

        Conexion.cerrarConexion();
        return resultado;
    }
}
