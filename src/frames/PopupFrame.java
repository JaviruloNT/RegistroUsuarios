package frames;

import javax.swing.*;
import java.awt.*;

public class PopupFrame extends JFrame {
    JLabel textLabel;
    JButton okButton;
    final int WIDTH = 600;
    final int HEIGHT = 150;
    public PopupFrame(String text) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        // Label
        textLabel = new JLabel(text);
        textLabel.setPreferredSize(new Dimension(550,50));
        textLabel.setFocusable(false);
        textLabel.setHorizontalAlignment(0);
        textLabel.setVerticalAlignment(0);
        this.add(textLabel);
        // Button
        okButton = new JButton("Aceptar");
        okButton.setPreferredSize(new Dimension(200,50));
        okButton.setFocusable(false);
        okButton.setHorizontalAlignment(0);
        okButton.setVerticalAlignment(0);
        okButton.addActionListener(_ -> this.dispose());
        this.add(okButton);
        //
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PopupFrame("Test");
    }
}
