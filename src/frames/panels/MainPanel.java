package frames.panels;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    JLabel titleLabel;
    JTextArea textArea;
    public MainPanel() {
        this.setPreferredSize(new Dimension(750,400));
        this.setLayout(new FlowLayout());
        //
        titleLabel = new JLabel("Lorem Ipsum");
        titleLabel.setPreferredSize(new Dimension(700,50));
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN,24));
        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(titleLabel);
        //
        textArea = new JTextArea("Lorem ipsum dolor sit amet consectetur adipiscing elit. Quisque faucibus ex sapien vitae pellentesque sem placerat. In id cursus mi pretium tellus duis convallis. Tempus leo eu aenean sed diam urna tempor. Pulvinar vivamus fringilla lacus nec metus bibendum egestas. Iaculis massa nisl malesuada lacinia integer nunc posuere. Ut hendrerit semper vel class aptent taciti sociosqu. Ad litora torquent per conubia nostra inceptos himenaeos.");
        textArea.setPreferredSize(new Dimension(700,300));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        //
        this.add(textArea);
    }
}
