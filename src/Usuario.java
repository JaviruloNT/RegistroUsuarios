public class Usuario {
    private static int cantUsuario;
    private int codigo;
    private String usuario;
    private String contrasena;
    //
    public Usuario() {}
    public Usuario(String usuario, String contrasena) {
        cantUsuario++;
        this.codigo = cantUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    //
    public int getCodigo() {
        return codigo;
    }

    public String getContrasena() {
        return contrasena;
    }
    public String getUsuario() {
        return usuario;
    }
}
