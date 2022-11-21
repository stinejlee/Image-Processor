package view;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import model.IImage;
import model.Image;
import model.ImageProcessingModelState;

public class ImagePanel extends JPanel {
  private JScrollPane scrollPane;
  private JLabel imageLabel;

  private BufferedImage currImage;

  public ImagePanel(BufferedImage image) {
    super();

    this.setBackground(Color.lightGray);
    this.setBorder(BorderFactory.createTitledBorder("Image"));
    this.setLayout(new GridLayout(1,0, 10, 10));
    this.setVisible(true);

    this.imageLabel = new JLabel();
    if (image != null) {
      imageLabel.setIcon(new ImageIcon(image));
    }
    this.scrollPane = new JScrollPane(imageLabel);
    this.scrollPane.setBackground(Color.DARK_GRAY);
    this.scrollPane.setPreferredSize(new Dimension(100, 100));
    this.add(scrollPane);

  }
}
