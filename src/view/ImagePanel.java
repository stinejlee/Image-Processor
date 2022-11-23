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

    JLabel imageLabel = new JLabel();
    if (image != null) {
      imageLabel.setIcon(new ImageIcon(image));
    }
    JScrollPane scrollPane = new JScrollPane(imageLabel);
    scrollPane.setBackground(Color.DARK_GRAY);
    scrollPane.setPreferredSize(new Dimension(100, 100));
    this.add(scrollPane);
  }
}
