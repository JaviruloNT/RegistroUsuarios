import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Locale;

public class RegisterFrame extends JFrame implements ActionListener {
    boolean buttonsEnabled = true;
    JLabel title;
    JLabel usrLabel;
    JTextField usrField;
    JLabel pwLabel;
    JPasswordField pwField;
    JButton registerButton;
    final int WIDTH = 300;
    final int HEIGHT = 400;
    //
    public RegisterFrame() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        // Label Titulo
        title = new JLabel("Registre su cuenta");
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
        // Button Registrar
        registerButton = new JButton("Registrar");
        registerButton.setPreferredSize(new Dimension(100,50));
        registerButton.addActionListener(this);
        registerButton.setFocusable(false);
        this.add(registerButton);
        //
        this.setVisible(true);
    }
    //

    public static void main(String[] args) {
        new RegisterFrame();
    }

    // Activar/desactivar botones
    private void toggleButtons() {
        buttonsEnabled = !buttonsEnabled;
        registerButton.setEnabled(buttonsEnabled);
        usrField.setEnabled(buttonsEnabled);
        pwField.setEnabled(buttonsEnabled);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        toggleButtons();
        // Verificar campos vacios
        if (usrField.getText().isEmpty() || pwField.getPassword().length == 0) {
            System.out.println("Usuario o contrasena vacios.");
            toggleButtons();
            return;
        }
        String path = "users/" + usrField.getText().toLowerCase() + ".xml";
        File file = new File(path);
        // Verificar si existe usuario con ese nombre
        if (file.exists()) {
            System.out.println("El usuario ya existe.");
            toggleButtons();
            return;
        }
        // Registrar usuario
        Usuario usuario = new Usuario(usrField.getText(),pwField.getPassword());
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file))) {
            encoder.writeObject(usuario);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Cerrar
        this.dispose();
    }
}
