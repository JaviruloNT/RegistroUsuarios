public class Usuario {
    private static int cantUsuario;
    private int codigo;
    private String usuario;
    private char[] contrasena;
    //
    public Usuario() {}
    public Usuario(String usuario, char[] contrasena) {
        cantUsuario++;
        this.codigo = cantUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    //
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
