public class UsuarioDTO {
    private int userID;
    private String nombre;
    private String email;
    private String tipo;

    // Constructor
    public UsuarioDTO(int userID, String nombre, String email, String tipo) {
        this.userID = userID;
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
