package modeloDAO;

import config.Conexion;
import modelo.Auditoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import interfaces.InterfazAuditoriaDAO;

public class AuditoriaDAO implements InterfazAuditoriaDAO {

    Connection con;
    PreparedStatement ps;

    public boolean registrarAccion(Auditoria auditoria) {
        String sql = "INSERT INTO auditoria(usuario, accion, modulo, fecha) VALUES (?, ?, ?, NOW())";
        try {
            con = Conexion.Conectar(); // ✅ conexión estática según tu clase actual
            ps = con.prepareStatement(sql);
            ps.setString(1, auditoria.getUsuario());
            ps.setString(2, auditoria.getAccion());
            ps.setString(3, auditoria.getModulo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ✅ NUEVO: alias para el nombre usado en ControladorProductos
    public boolean agregarRegistro(Auditoria auditoria) {
        return registrarAccion(auditoria);
    }
}
