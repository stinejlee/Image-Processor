package view;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

/**
 * Represents a Panel that displays the current Image and allows the user to scroll through
 * the image if it is too large.
 */
public class ImagePanel extends JPanel {
  private JScrollPane scrollPane;
  private JLabel imageLabel;

  /**
   * The constructor for the ImagePanel class that takes in the view's current image.
   * @param image the current image in the view that needs to be displayed.
   */
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
