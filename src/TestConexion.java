import java.sql.*;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/FoodWasteTracker";
        String usuario = "root"; // <- Usuario
        String contraseña = "Codigorojo7*"; // <- contraseña 

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            System.out.println("✅ Conexión exitosa a la base de datos.\n");

            DatabaseMetaData meta = conexion.getMetaData();
            ResultSet tablas = meta.getTables(null, null, "%", new String[] { "TABLE" });

            System.out.println("📋 Tablas en la base de datos:");
            while (tablas.next()) {
                String nombreTabla = tablas.getString("TABLE_NAME");
                System.out.println(" - " + nombreTabla);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar o consultar: " + e.getMessage());
        }
    }
}
