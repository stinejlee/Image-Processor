package view;

import java.io.IOException;

/**
 * Represents a view for the image processor.
 */
public interface ImageProcessingView {
  public void writeMessage(String message) throws IOException;
}
