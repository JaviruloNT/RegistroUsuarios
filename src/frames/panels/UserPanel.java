package frames.panels;
import frames.Usuario;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    JLabel changeUserLabel;
    JLabel changePassLabel;
    JLabel newUserLabel;
    JLabel oldPassLabel;
    JLabel currentPassLabel;
    JTextField userField;
    JPasswordField changeUserPwField;
    JPasswordField changePassPwField;
    JButton changeUserButton;
    JButton changePassButton;
    JButton logoutButton;
    public UserPanel(Usuario user) {
        this.setPreferredSize(new Dimension(750,400));
        this.setLayout(new FlowLayout());
        //
        changeUserLabel = new JLabel("Cambiar nombre de usuario");
        changeUserLabel.setPreferredSize(new Dimension(700,50));
        changeUserLabel.setHorizontalAlignment(JLabel.CENTER);
        changeUserLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(changeUserLabel);
        //
        newUserLabel = new JLabel("Nuevo nombre:");
        newUserLabel.setPreferredSize(new Dimension(100,50));
        newUserLabel.setHorizontalAlignment(JLabel.RIGHT);
        newUserLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(newUserLabel);
        //
        userField = new JTextField();
        userField.setPreferredSize(new Dimension(150,25));
        this.add(userField);
        //
        currentPassLabel = new JLabel("Contrasena:");
        currentPassLabel.setPreferredSize(new Dimension(100,50));
        currentPassLabel.setHorizontalAlignment(JLabel.RIGHT);
        currentPassLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(currentPassLabel);
        //
        changeUserPwField = new JPasswordField();
        changeUserPwField.setPreferredSize(new Dimension(150,25));
        this.add(changeUserPwField);
        //
        changeUserButton = new JButton("Cambiar nombre");
        changeUserButton.setPreferredSize(new Dimension(150,50));
        changeUserButton.setFocusable(false);
        this.add(changeUserButton);
        //
        changePassLabel = new JLabel("Cambiar contrasena");
        changePassLabel.setPreferredSize(new Dimension(700,50));
        changePassLabel.setHorizontalAlignment(JLabel.CENTER);
        changePassLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(changePassLabel);
        // TODO: implementar visualizador de cambio de contrasena
        // TODO: implementar funcionalidad de cambio de usuario
    }
}
