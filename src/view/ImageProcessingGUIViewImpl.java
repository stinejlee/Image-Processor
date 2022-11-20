package view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import model.ImageProcessingModelState;

public class ImageProcessingGUIViewImpl extends JFrame implements ImageProcessingGUIView {

  ImageProcessingModelState modelState;
  JPanel imagePanel;
  JPanel commandPanel;
  JPanel redHistPanel;
  JPanel greenHistPanel;
  JPanel blueHistPanel;
  JPanel intensityHistPanel;

  String currentImage;

  //the custom panel on which the board will be drawn
  private JPanel boardPanel;

  public ImageProcessingGUIViewImpl(ImageProcessingModelState modelState) {
    super("Image Processor");
    this.modelState = modelState;
    this.setLayout(new BorderLayout());

  }
  @Override
  public void refresh() {

  }

  @Override
  public void paint(Graphics g) {
    paintRedHistogram(g);
    paintGreenHistogram(g);
    paintBlueHistogram(g);
    paintIntensityHistogram(g);
  }

  private void paintRedHistogram(Graphics g) {

  }

  private void paintGreenHistogram(Graphics g) {

  }

  private void paintBlueHistogram(Graphics g) {

  }

  private void paintIntensityHistogram(Graphics g) {

  }

  @Override
  public void writeMessage(String message) throws IOException {
    return;
  }
}
