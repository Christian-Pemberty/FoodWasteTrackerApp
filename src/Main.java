import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/FoodWasteTracker";
        String usuario = "root";
        String contraseña = "Codigorojo7*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            UsuarioDAO dao = new UsuarioDAO(conexion);

            System.out.println("✅ Insertando nuevo usuario...");
            UsuarioDTO nuevo = new UsuarioDTO(10, "Laura Gómez", "laura@hogar.com", "hogar");
            dao.insertarUsuario(nuevo);

            System.out.println("✅ Actualizando nombre del usuario 10...");
            dao.actualizarNombre(10, "Laura G.");

            System.out.println("📋 Mostrando nombres y tipos:");
            List<UsuarioDTO> lista = dao.obtenerNombresYTipos();
            for (UsuarioDTO u : lista) {
                System.out.println(" - " + u.getNombre() + " (" + u.getTipo() + ")");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
