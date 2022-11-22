package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Feature;

public class ImageProcessingGUIViewImpl extends JFrame implements ImageProcessingGUIView {

  private Feature feature;
  private JPanel imagePanel;
  private JTextPane textPane;
  private JPanel buttonPanel;
  private JTextField input;

  private JSpinner valueSpinner;
  JComboBox<String> comboBox;
  private JButton load;
  private JButton apply;

  private String filePath;
  private BufferedImage currentImage;

  private JButton applyBrighten;
  private JButton save;
  private JPanel commandPanel;
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


  //the custom panel on which the board will be drawn
  private JPanel boardPanel;

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

    this.redHistPanel = new RedHistogramPanel(currentImage);
    this.histPanel1.add(redHistPanel);

    // Area for other two histograms
    this.histPanel2 = new JPanel();
    this.histPanel2.setLayout(new GridLayout(2, 1,  10, 10));
    this.add(histPanel2);

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

    this.applyPanel = new JPanel();
    this.applyPanel.setLayout(new FlowLayout());
    this.apply = new JButton("Apply");
    this.apply.setVisible(true);
    this.applyPanel.add(apply);
    this.buttonPanel.add(applyPanel, BorderLayout.CENTER);

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

  public void addActionListener() {
    this.load.addActionListener((event) -> feature.load());
    this.save.addActionListener((event) -> feature.save());
    this.apply.addActionListener((event) -> feature.apply((String) comboBox.getSelectedItem(), (int) valueSpinner.getValue()));
    this.applyBrighten.addActionListener((event) -> feature.apply("Brighten", (int) valueSpinner.getValue()));
  }

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

  public void setCurrentImage(BufferedImage image) {
    this.currentImage = image;
  }

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

  public void resetHistPanels() {
    System.out.println("2testing");
    this.histPanel1.removeAll();
    JPanel newRedHistPanel = new RedHistogramPanel(currentImage);
    this.histPanel1.add(newRedHistPanel);
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
