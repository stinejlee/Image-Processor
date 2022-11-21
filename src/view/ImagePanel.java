package view;

import java.awt.*;

import javax.swing.*;

import model.IImage;
import model.Image;
import model.ImageProcessingModelState;

public class ImagePanel extends JPanel {
  private JScrollPane scrollPane;
  private JLabel imageLabel;

  public ImagePanel() {
    super();

    this.setBackground(Color.lightGray);
    this.setBorder(BorderFactory.createTitledBorder("Image"));
    this.setLayout(new GridLayout(1,0, 10, 10));
    this.setVisible(true);

    this.imageLabel = new JLabel();
    this.scrollPane = new JScrollPane(imageLabel);
    this.scrollPane.setBackground(Color.DARK_GRAY);
    imageLabel.setIcon(new ImageIcon("res/sailor.jpg")); // ignore this image i needed to make sure it scrolled
    this.scrollPane.setPreferredSize(new Dimension(100, 100));
    this.add(scrollPane);

  }
}
