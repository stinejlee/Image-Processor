package view;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.event.ListSelectionListener;

import controller.Feature;

/**
 * Represents the GUI view of the image processor program and is connected to a feature/controller.
 */
public interface ImageProcessingGUIView extends ImageProcessingView {
  /**
   * Sets this ImageProcessingGuiView's feature as the given feature. This is called in the
   * feature's constructor.
   * @param feature
   */
  void setFeature(Feature feature);

  /**
   * Opens a file chooser for the user to select an image file to open.
   * @return the absolute filepath of the image file.
   */
  String loadImage();

  /**
   * Sets the current image displayed in the GUI as the given BufferedImage.
   * @param image the new image to be displayed as the current image.
   */
  void setCurrentImage(BufferedImage image);

  /**
   * Allows the user to designate a filepath to save their current image.
   * @return the designated absolute filepath.
   */
  String saveImage();

  /**
   * Refreshes the image panel so that a new image can be displayed. This is called after an image
   * is loaded or when a filter is applied so that the resulting image can be seen in real time.
   */
  void resetImagePanel();

  /**
   * Refreshes the histogram panels so that the histograms can be updated when an image is
   * displayed. This is called whenever an image is loaded or filters are applied to the image.
   */
  void resetHistPanels();
}
