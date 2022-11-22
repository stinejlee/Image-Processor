package view;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import controller.Feature;

/**
 * An implementation of a ImageProcessingGUIView that is connected to a Feature (controller) and
 * displays the GUI of the Image Processing Program.
 */
public class ImageProcessingGUIViewImpl extends JFrame implements ImageProcessingGUIView {
  private Feature feature;
  private JPanel imagePanel;
  private JPanel buttonPanel;
  private JSpinner valueSpinner;
  JComboBox<String> comboBox;
  private JButton load;
  private JButton apply;
  private String filePath;
  private BufferedImage currentImage;
  private JButton applyBrighten;
  private JButton save;
  private JPanel redHistPanel;
  private JPanel greenHistPanel;
  private JPanel blueHistPanel;
  private JPanel intensityHistPanel;
  private JPanel loadPanel;
  private JPanel savePanel;
  private JPanel applyPanel;
  private JPanel applyBrightenPanel;
  private JPanel histPanel1;
  private JPanel histPanel2;

  /**
   * The constructor for the ImageProcessingGUIViewImpl class. This does not initialize feature.
   * Feature is only initialized once a feature is initialized with this view.
   */
  public ImageProcessingGUIViewImpl() {
    super("Image Processor");
    this.setSize(1000, 1000);
    this.setLayout(new GridLayout(2, 3));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.imagePanel = new ImagePanel(currentImage);
    this.add(imagePanel);

    // Area for ioCommands
    this.buttonPanel = new JPanel();
    this.buttonPanel.setPreferredSize(new Dimension(200, 300));
    this.buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
    this.buttonPanel.setLayout(new BorderLayout());
    this.add(buttonPanel);

    // Area for first two histograms
    this.histPanel1 = new JPanel();
    this.histPanel1.setLayout(new GridLayout(2, 1,  10, 10));
    this.add(histPanel1);

    this.redHistPanel = new HistogramPanel("Red");
    this.greenHistPanel = new HistogramPanel("Green");
    this.histPanel1.add(redHistPanel);
    this.histPanel1.add(greenHistPanel);

    // Area for other two histograms
    this.histPanel2 = new JPanel();
    this.histPanel2.setLayout(new GridLayout(2, 1,  10, 10));
    this.add(histPanel2);

    this.blueHistPanel = new HistogramPanel("Blue");
    this.intensityHistPanel = new HistogramPanel("Green");
    this.histPanel2.add(blueHistPanel);
    this.histPanel2.add(intensityHistPanel);

    // Area for ioCommands
    this.loadPanel = new JPanel();
    this.loadPanel.setLayout(new FlowLayout());
    this.load = new JButton("Load");
    this.load.setVisible(true);
    this.loadPanel.add(load);
    this.buttonPanel.add(loadPanel, BorderLayout.WEST);

    this.savePanel = new JPanel();
    this.savePanel.setLayout(new FlowLayout());
    this.save = new JButton("Save");
    this.save.setVisible(true);
    this.savePanel.add(save);
    this.buttonPanel.add(savePanel, BorderLayout.EAST);

    // Combo box consisting of all the image processing options.
    JPanel comboBoxPanel = new JPanel();
    this.buttonPanel.add(comboBoxPanel);
    this.comboBox = new JComboBox<>();
    JLabel comboBoxDisplay = new JLabel("Select filter");
    comboBoxPanel.add(comboBoxDisplay);
    String[] filters = {"Blur", "Sharpen", "Red Greyscale", "Green Greyscale",
            "Blue Greyscale", "Intensity Greyscale", "Value Greyscale",
            "Luma Greyscale", "Sepia", "Horizontal Flip", "Vertical Flip"};

    for (int i = 0; i < filters.length; i++) {
      this.comboBox.addItem(filters[i]);
    }

    comboBoxPanel.add(comboBox);
    this.buttonPanel.add(comboBoxPanel, BorderLayout.NORTH);

    // Apply button panel
    this.applyPanel = new JPanel();
    this.applyPanel.setLayout(new FlowLayout());
    this.apply = new JButton("Apply");
    this.apply.setVisible(true);
    this.applyPanel.add(apply);
    this.buttonPanel.add(applyPanel, BorderLayout.CENTER);

    // Number value spinner for brighten/darken
    int current = 0;
    int min = -255;
    int max = 255;
    int step = 1;

    JPanel spinnerPanel = new JPanel();
    JLabel spinnerLabel = new JLabel("Brighten by:");
    SpinnerNumberModel valueModel = new SpinnerNumberModel(current, min, max, step);
    this.valueSpinner = new JSpinner(valueModel);
    spinnerPanel.add(spinnerLabel);
    spinnerPanel.add(valueSpinner);

    this.applyBrightenPanel = new JPanel();
    this.applyBrightenPanel.setLayout(new FlowLayout());
    this.applyBrighten = new JButton("Apply");
    this.applyBrighten.setVisible(true);
    spinnerPanel.add(applyBrighten);

    this.buttonPanel.add(spinnerPanel, BorderLayout.SOUTH);

    this.addActionListener();
    this.setVisible(true);
  }

  /**
   * Adds action listeners to each of the buttons in the GUI
   * that call methods in the feature/controller.
   */
  private void addActionListener() {
    this.load.addActionListener((event) -> feature.load());
    this.save.addActionListener((event) -> feature.save());
    this.apply.addActionListener((event) ->
            feature.apply((String) comboBox.getSelectedItem(), (int) valueSpinner.getValue()));
    this.applyBrighten.addActionListener((event) ->
            feature.apply("Brighten", (int) valueSpinner.getValue()));
  }

  @Override
  public String loadImage() {
    final JFileChooser fchooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Images", "jpg", "ppm", "png", "bmp");
    fchooser.setFileFilter(filter);
    int retvalue = fchooser.showOpenDialog(this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      this.filePath = f.getAbsolutePath();
    }
    return this.filePath;
  }

  @Override
  public void setCurrentImage(BufferedImage image) {
    this.currentImage = image;
  }

  @Override
  public void resetImagePanel() {
    System.out.println("testing");
    this.imagePanel.removeAll();
    JLabel newLabel = new JLabel();
    newLabel.setIcon(new ImageIcon(currentImage));
    JScrollPane newScrollPane = new JScrollPane(newLabel);
    newScrollPane.setBackground(Color.DARK_GRAY);
    newScrollPane.setPreferredSize(new Dimension(100, 100));
    this.imagePanel.add(newScrollPane);
    this.setVisible(false);
    this.repaint();
    this.setVisible(true);
  }

  @Override
  public void resetHistPanels() {
    System.out.println("2testing");
    this.histPanel1.removeAll();
    this.histPanel2.removeAll();

    double maxPercentage = 0;
    int[] redValueCounts = new int[256];
    double[] redPercentages = new double[256];
    int[] greenValueCounts = new int[256];
    double[] greenPercentages = new double[256];
    int[] blueValueCounts = new int[256];
    double[] bluePercentages = new double[256];
    int[] intensityValueCounts = new int[256];
    double[] intPercentages = new double[256];

    for (int i = 0; i < currentImage.getHeight(); i++) {
      for (int j = 0; j < currentImage.getWidth(); j++) {
        Color pixel = new Color(currentImage.getRGB(j, i));
        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();
        int intensity = Math.max(Math.max(red, green), blue);
        redValueCounts[red]++;
        greenValueCounts[green]++;
        blueValueCounts[blue]++;
        intensityValueCounts[intensity]++;
      }
    }

    int totalPixels = this.currentImage.getWidth() * this.currentImage.getHeight();

    for (int i = 0; i < 256; i++) {
      redPercentages[i] = (double) redValueCounts[i] / totalPixels;
      greenPercentages[i] = (double) greenValueCounts[i] / totalPixels;
      bluePercentages[i] = (double) blueValueCounts[i] / totalPixels;
      intPercentages[i] = (double) intensityValueCounts[i] / totalPixels;
      double maxPercent = Math.max(redPercentages[i], Math.max(greenPercentages[i],
              Math.max(bluePercentages[i], intPercentages[i])));
      if (maxPercentage < maxPercent) {
        maxPercentage = maxPercent;
      }
    }
    JPanel newRedHistPanel = new HistogramPanel(redPercentages, Color.RED, maxPercentage, "Red");
    JPanel newGreenHistPanel = new HistogramPanel(greenPercentages, Color.GREEN, maxPercentage, "Green");
    JPanel newBlueHistPanel = new HistogramPanel(bluePercentages, Color.BLUE, maxPercentage, "Blue");
    JPanel newIntHistPanel = new HistogramPanel(intPercentages, Color.GRAY, maxPercentage, "Intensity");
    this.histPanel1.add(newRedHistPanel);
    this.histPanel1.add(newGreenHistPanel);
    this.histPanel2.add(newBlueHistPanel);
    this.histPanel2.add(newIntHistPanel);
    this.setVisible(false);
    this.repaint();
    this.setVisible(true);

  }

  @Override
  public String saveImage() {
    final JFileChooser fchooser = new JFileChooser(".");
    int retvalue = fchooser.showSaveDialog(this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      return f.getAbsolutePath();
    }
    else {
      throw new IllegalStateException("Something went wrong");
    }
  }

  @Override
  public void writeMessage(String message) throws IOException {
    return;
  }
//  @Override
//  public void showErrorMessage(String error) {
//    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
//
//  }


  @Override
  public void setFeature(Feature feature) {
    this.feature = feature;
  }
}
