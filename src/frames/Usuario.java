package frames;

public class Usuario {
    private String usuario;
    private char[] contrasena;
    //
    public Usuario() {}
    public Usuario(String usuario, char[] contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    //
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(char[] contrasena) {
        this.contrasena = contrasena;
    }

    public char[] getContrasena() {
        return contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

}
