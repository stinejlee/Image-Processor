package view;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import model.IImage;
import model.Pixel;

public class RedHistogramPanel extends JPanel {
  private int[] valueCounts;
  private BufferedImage image;

  public RedHistogramPanel() {
    super();

    this.valueCounts = new int[256];
    int totalPixels = image.getHeight() * image.getWidth();

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Color pixel = new Color(this.image.getRGB(j, i));
        int red = pixel.getRed();
        valueCounts[red]++;
      }
    }

    for (int i = 0; i < valueCounts.length; i++) {
      valueCounts[i] = valueCounts[i] / totalPixels;
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

  }
}
