package frames;

import javax.swing.*;
import java.awt.*;

public class SystemFrame extends JFrame {
    JLabel title;
    JButton logoutButton;
    final int WIDTH = 300;
    final int HEIGHT = 400;
    public SystemFrame(Usuario user) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        // Label Titulo
        title = new JLabel(String.format("Bienivenido, %s!",user.getUsuario()));
        title.setPreferredSize(new Dimension(150,50));
        title.setFocusable(false);
        title.setHorizontalAlignment(0);
        title.setVerticalAlignment(0);
        this.add(title);
        // Button Cerrar Sesion
        logoutButton = new JButton("Cerrar sesion");
        logoutButton.addActionListener(e -> {
            new MainFrame();
            this.dispose();
        });
        logoutButton.setFocusable(false);
        logoutButton.setPreferredSize(new Dimension(150,50));
        this.add(logoutButton);
        //
        this.setVisible(true);
    }
}
