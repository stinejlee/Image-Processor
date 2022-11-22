package view;

import java.awt.*;

import javax.swing.*;

public class ControlPanel extends JPanel {
  JButton load;
  JButton save;
  JButton apply;

  public ControlPanel() {
    this.setBackground(Color.WHITE);
    this.setBorder(BorderFactory.createTitledBorder("Control Panel"));
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

  }

}
