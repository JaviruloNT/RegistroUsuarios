import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JLabel title;
    JButton registerButton;
    JButton loginButton;
    final int WIDTH = 300;
    final int HEIGHT = 400;
    public MainFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        // Label Bienvenida
        title = new JLabel("Sistema");
        title.setPreferredSize(new Dimension(150,50));
        title.setFocusable(false);
        title.setHorizontalAlignment(0);
        title.setVerticalAlignment(0);
        this.add(title);
        // Boton Registro
        registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> new RegisterFrame());
        registerButton.setFocusable(false);
        registerButton.setPreferredSize(new Dimension(150,50));
        this.add(registerButton);
        // Boton Login
        loginButton = new JButton("Ingresar");
        loginButton.addActionListener(e -> {
            new LoginFrame();
        });
        loginButton.setFocusable(false);
        loginButton.setPreferredSize(new Dimension(150,50));
        this.add(loginButton);
        //
        this.setVisible(true);
    }
    //

    public static void main(String[] args) {
        new MainFrame();
    }
}
