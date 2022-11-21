package view;

import java.io.IOException;

import controller.Feature;
import controller.ImageProcessingControllerGUI;

/**
 * Represents a view for the image processor.
 */
public interface ImageProcessingView {
  public void writeMessage(String message) throws IOException;
}
