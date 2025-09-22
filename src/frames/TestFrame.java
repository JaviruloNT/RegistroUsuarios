package frames;

import frames.panels.MainPanel;
import frames.panels.UserPanel;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {
    JLabel welcomeLabel;
    JLabel userLabel;
    JButton logoutButton;
    JTabbedPane tabs;
    MainPanel mainPanel;
    UserPanel userPanel;
    public TestFrame(Usuario user) {
        // TODO: reemplazar systemframe por testframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        // Bienvenida Label
        welcomeLabel = new JLabel("Bienivenido/a!");
        welcomeLabel.setPreferredSize(new Dimension(300,50));
        welcomeLabel.setFont(new Font(welcomeLabel.getFont().getName(), Font.PLAIN,24));
        welcomeLabel.setHorizontalAlignment(JLabel.LEFT);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(welcomeLabel);
        // Usuario Label
        userLabel = new JLabel(String.format("Iniciado sesion como %s.",user.getUsuario().toUpperCase()));
        userLabel.setPreferredSize(new Dimension(300,50));
        userLabel.setHorizontalAlignment(JLabel.RIGHT);
        userLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(userLabel);
        // Cerrar Sesion Button
        logoutButton = new JButton("Cerrar sesion");
        logoutButton.setPreferredSize(new Dimension(150,50));
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(_ -> {
            new MainFrame();
            this.dispose();
        });
        this.add(logoutButton);
        //
        userPanel = new UserPanel(user);
        mainPanel = new MainPanel();
        //
        tabs = new JTabbedPane();
        tabs.addTab("Home",mainPanel);
        tabs.addTab("User",userPanel);
        this.add(tabs);
        //
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame(new Usuario("admin",new char[]{'a','s','d','f'}));
    }
}
