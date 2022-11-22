package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

/**
 * Represents a panel that displays a histogram given the information it should display.
 */
public class HistogramPanel extends JPanel {
  private double[] valuePercentages;
  private Color color;
  private double maxValue;

  /**
   * The constructor for the HistogramPanel class that takes four arguments.
   * @param valuePercentages the values being displayed on the histogram.
   * @param color the color of the histogram.
   * @param maxValue the maximum value that the histogram can display.
   * @param title the title of this panel.
   */
  public HistogramPanel(double[] valuePercentages, Color color, double maxValue, String title) {
    this.color = color;
    this.maxValue = maxValue;
    this.valuePercentages = valuePercentages;
    this.setBackground(Color.lightGray);
    this.setBorder(BorderFactory.createTitledBorder(title));
    this.setVisible(true);
  }

  /**
   * The constructor for the HistogramPanel class that only takes in the title. This is only used
   * before an image is loaded into the program.
   * @param title the title of the histogram panel.
   */
  public HistogramPanel(String title) {
    this(new double[0], Color.BLACK, 0, title);
  }

  // draws the histogram.
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < valuePercentages.length; i++) {
      g.setColor(this.color);
      g.drawRect(i + 20, this.getHeight() - 20, 1,
              (int) -(valuePercentages[i] * ((this.getHeight() - 40) / maxValue)));

    }
  }
}
