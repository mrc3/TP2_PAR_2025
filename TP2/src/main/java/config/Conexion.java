package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String user = "root"; // usuario correcto
    private static final String password = "1234"; // usa tu contraseña real aquí
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/tp2";
    private static Connection conexion = null;

    public Conexion() {
    }

    public static Connection Conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontró el driver JDBC");
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar: " + ex.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexión");
        }
    }
}
