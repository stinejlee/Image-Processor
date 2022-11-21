package view;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.event.ListSelectionListener;

import controller.Feature;

public interface ImageProcessingGUIView extends ImageProcessingView {
  void setFeature(Feature feature);

  String loadImage();

  void setCurrentImage(BufferedImage image);

  String saveImage();

  void resetImagePanel();
}
