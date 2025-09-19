import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.Arrays;

public class LoginFrame extends JFrame implements ActionListener {
    boolean buttonsEnabled = true;
    JFrame mainFrame;
    JLabel title;
    JLabel usrLabel;
    JTextField usrField;
    JLabel pwLabel;
    JPasswordField pwField;
    JButton loginButton;
    final int WIDTH = 300;
    final int HEIGHT = 400;
    //
    public LoginFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        // Label Titulo
        title = new JLabel("Inicie sesion");
        title.setPreferredSize(new Dimension(200,50));
        title.setFocusable(false);
        title.setHorizontalAlignment(0);
        title.setVerticalAlignment(0);
        this.add(title);
        // Label Usuario
        usrLabel = new JLabel("Usuario:");
        usrLabel.setPreferredSize(new Dimension(100,50));
        usrLabel.setFocusable(false);
        usrLabel.setHorizontalAlignment(0);
        usrLabel.setVerticalAlignment(0);
        this.add(usrLabel);
        // Field Usuario
        usrField = new JTextField();
        usrField.setPreferredSize(new Dimension(100,25));
        usrField.addActionListener(this);
        this.add(usrField);
        // Label Contrasena
        pwLabel = new JLabel("Contrasena:");
        pwLabel.setPreferredSize(new Dimension(100,50));
        pwLabel.setFocusable(false);
        pwLabel.setHorizontalAlignment(0);
        pwLabel.setVerticalAlignment(0);
        this.add(pwLabel);
        // Field Contrasena
        pwField = new JPasswordField();
        pwField.setPreferredSize(new Dimension(100,25));
        pwField.addActionListener(this);
        this.add(pwField);
        // Button Ingresar
        loginButton = new JButton("Ingresar");
        loginButton.setPreferredSize(new Dimension(100,50));
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        this.add(loginButton);
        //
        this.setVisible(true);
    }
    //

    public static void main(String[] args) {
        new LoginFrame(new MainFrame());
    }

    // Activar/desactivar botones
    private void toggleButtons() {
        buttonsEnabled = !buttonsEnabled;
        loginButton.setEnabled(buttonsEnabled);
        usrField.setEnabled(buttonsEnabled);
        pwField.setEnabled(buttonsEnabled);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        toggleButtons();
        // Verificar campos vacios
        if (usrField.getText().isEmpty() || pwField.getPassword().length == 0) {
            new PopupFrame("Usuario o contrasena vacios.");
            toggleButtons();
            return;
        }
        String path = "users/" + usrField.getText().toLowerCase() + ".xml";
        File file = new File(path);
        // Verificar si no existe usuario con ese nombre
        if (!file.exists()) {
            new PopupFrame("Usuario o contrasena incorrectos.");
            toggleButtons();
            return;
        }
        //  Iniciar sesion
        Usuario usuario = null;
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(file))) {
            usuario = (Usuario) decoder.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Verificar si la contrasena es correcta
        if (!Arrays.equals(usuario.getContrasena(),pwField.getPassword())) {
            new PopupFrame("Usuario o contrasena incorrectos.");
            toggleButtons();
            return;
        }
        // Cerrar
        mainFrame.dispose();
        new SystemFrame(usuario);
        this.dispose();
    }
}
