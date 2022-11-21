package view;

import javax.swing.*;

import model.IImage;
import model.Pixel;

public class RedHistogramPanel extends JPanel {
  private int[] valueCounts;
  private IImage image;

  public RedHistogramPanel() {
    super();

    this.valueCounts = new int[256];
    int totalPixels = image.getHeight() * image.getWidth();

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel pix = this.image.getPixelAt(i, j);
        int red = pix.getRed();
        valueCounts[red]++;
      }
    }

    for (int i = 0; i < valueCounts.length; i++) {
      valueCounts[i] = valueCounts[i] / totalPixels;
    }
  }
}
