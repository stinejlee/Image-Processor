package view;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import controller.imagecommands.ValueGreyscale;

public class RedHistogramPanel extends JPanel {
  private int[] valueCounts = new int[0];
  private double[] valueCountsPercent;
  private int totalPixels;
  private double maxValue;

  public RedHistogramPanel(BufferedImage image) {
    super();

    if (image != null) {
      this.valueCounts = new int[256];
      this.valueCountsPercent = new double[256];
      totalPixels = image.getHeight() * image.getWidth();

      for (int i = 0; i < image.getHeight(); i++) {
        for (int j = 0; j < image.getWidth(); j++) {
          Color pixel = new Color(image.getRGB(j, i));
          int red = pixel.getRed();
          valueCounts[red]++;
        }
      }
      double x = 0.0;

      for (int i = 0; i < valueCounts.length; i++) {
        valueCountsPercent[i] = (double) valueCounts[i] / totalPixels;
      }

      for (int i = 0; i < valueCountsPercent.length; i++) {
        if (maxValue < valueCountsPercent[i]) {
          maxValue = valueCountsPercent[i];
        }
        valueCountsPercent[i] = (double) valueCounts[i] / totalPixels;
      }
    }

    this.setBackground(Color.lightGray);
    this.setBorder(BorderFactory.createTitledBorder("Red Histogram"));
    this.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < valueCounts.length; i++) {
      double x = (double) (i * (this.getWidth() - 40) / 265);
      g.setColor(Color.red);
      g.drawRect(i + 20, this.getHeight() - 20, 1,
             (int) -(valueCountsPercent[i] * ((this.getHeight() - 40) / maxValue)));

    }
  }
}
