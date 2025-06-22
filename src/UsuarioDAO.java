import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Inserción
    public void insertarUsuario(UsuarioDTO usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (userID, nombre, email, tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, usuario.getUserID());
        stmt.setString(2, usuario.getNombre());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getTipo());
        stmt.executeUpdate();
        stmt.close();
    }

    // Actualización
    public void actualizarNombre(int userID, String nuevoNombre) throws SQLException {
        String sql = "UPDATE Usuario SET nombre = ? WHERE userID = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nuevoNombre);
        stmt.setInt(2, userID);
        stmt.executeUpdate();
        stmt.close();
    }

    // Proyección (mostrar solo nombre y tipo)
    public List<UsuarioDTO> obtenerNombresYTipos() throws SQLException {
        String sql = "SELECT nombre, tipo FROM Usuario";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<UsuarioDTO> lista = new ArrayList<>();

        while (rs.next()) {
            UsuarioDTO u = new UsuarioDTO(0, rs.getString("nombre"), "", rs.getString("tipo"));
            lista.add(u);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
