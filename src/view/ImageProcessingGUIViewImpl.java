package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import java.util.function.Consumer;

import controller.Feature;
import controller.ImageProcessingCommand;
import model.ImageProcessingModelState;

public class ImageProcessingGUIViewImpl extends JFrame implements ImageProcessingGUIView {

  private Feature feature;
  private JPanel imagePanel;
  private JTextPane textPane;
  private JPanel buttonPanel;
  private JTextField input;
  private JButton load;
  private JButton execute;
  private JButton save;
  private JList<String> listOfStrings;
  private JList<Integer> listOfIntegers;
  private JPanel commandPanel;
  private JPanel redHistPanel;
  private JPanel greenHistPanel;
  private JPanel blueHistPanel;
  private JPanel intensityHistPanel;
  private JPanel loadPanel;
  private JPanel savePanel;

  String currentImage;

  //the custom panel on which the board will be drawn
  private JPanel boardPanel;

  public ImageProcessingGUIViewImpl() {
    super("Image Processor");
    this.setSize(1000, 1000);
    this.setLayout(new GridLayout(2, 3));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.imagePanel = new ImagePanel();
    this.add(imagePanel);

    // Area for ioCommands
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    // Area for ioCommands
    loadPanel = new JPanel();
    loadPanel.setLayout(new FlowLayout());
    this.add(buttonPanel);
    load = new JButton("load");
    load.setVisible(true);
    loadPanel.add(load);
    buttonPanel.add(loadPanel);

    savePanel = new JPanel();
    savePanel.setLayout(new FlowLayout());
    this.add(buttonPanel);
    save = new JButton("save");
    save.setVisible(true);
    savePanel.add(save);
    buttonPanel.add(save);

//    //file open
//    JPanel fileopenPanel = new JPanel();
//    fileopenPanel.setLayout(new FlowLayout());
//    dialogBoxesPanel.add(fileopenPanel);
//    JButton fileOpenButton = new JButton("Open a file");
//    fileOpenButton.setActionCommand("Open file");
//    fileOpenButton.addActionListener(this);
//    fileopenPanel.add(fileOpenButton);
//    fileOpenDisplay = new JLabel("File path will appear here");
//    fileopenPanel.add(fileOpenDisplay);
//
//    //file save
//    JPanel filesavePanel = new JPanel();
//    filesavePanel.setLayout(new FlowLayout());
//    dialogBoxesPanel.add(filesavePanel);
//    JButton fileSaveButton = new JButton("Save a file");
//    fileSaveButton.setActionCommand("Save file");
//    fileSaveButton.addActionListener(this);
//    filesavePanel.add(fileSaveButton);
//    fileSaveDisplay = new JLabel("File path will appear here");
//    filesavePanel.add(fileSaveDisplay);


//    // Area for ImageProcessingCommands
//    commandPanel = new JPanel();
//    commandPanel.setLayout(new FlowLayout());
//    this.add(commandPanel, BorderLayout.SOUTH);
//
//    JPanel selectionListPanel = new JPanel();
//    selectionListPanel.setBorder(BorderFactory.createTitledBorder("Selection lists"));
//    selectionListPanel.setLayout(new BoxLayout(selectionListPanel, BoxLayout.X_AXIS));
//    commandPanel.add(selectionListPanel);
//
//    DefaultListModel<String> dataForListOfStrings = new DefaultListModel<>();
//    dataForListOfStrings.addElement("Apple");
//    dataForListOfStrings.addElement("Bear");
//    dataForListOfStrings.addElement("Cave");
//    dataForListOfStrings.addElement("Decorate");
//    dataForListOfStrings.addElement("Exciting");
//    dataForListOfStrings.addElement("Flicker");
//    listOfStrings = new JList<>(dataForListOfStrings);
//    listOfStrings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    listOfStrings.addListSelectionListener(this);
//    selectionListPanel.add(listOfStrings);
//
//
//    DefaultListModel<Integer> dataForListOfIntegers = new DefaultListModel<>();
//    for (int i = 0; i < 1000; i++)
//      dataForListOfIntegers.addElement(i);
//    listOfIntegers = new JList<>(dataForListOfIntegers);
//    listOfIntegers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    listOfIntegers.addListSelectionListener(this);
//    selectionListPanel.add(new JScrollPane(listOfIntegers));
//
//
//    //input textfield
//    input = new JTextField(15);
//    buttonPanel.add(input);

    this.setVisible(true);
  }

  public void addActionListener() {
    load.addActionListener((event) -> feature.load()); // this is what each of our buttons will have, just w corresponding methods
  }
//  @Override
//  public void refresh() {
//    this.repaint();
//  }
//
//  @Override
//  public void setCommandButtonListener(ActionListener actionEvent) {
//    execute.addActionListener(actionEvent);
//  }
//
//  @Override
//  public void setListSelectionListener(ListSelectionListener actionEvent) {
//    listOfStrings.addListSelectionListener(actionEvent);
//  }
//
//  @Override
//  public void paint(Graphics g) {
//    paintRedHistogram(g);
//    paintGreenHistogram(g);
//    paintBlueHistogram(g);
//    paintIntensityHistogram(g);
//  }
//
//  private void paintRedHistogram(Graphics g) {
//  }
//
//  private void paintGreenHistogram(Graphics g) {
//
//  }
//
//  private void paintBlueHistogram(Graphics g) {
//
//  }
//
//  private void paintIntensityHistogram(Graphics g) {
//
//  }
//
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
