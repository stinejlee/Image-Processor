package view;

import java.io.IOException;

import model.ImageProcessingModel;

/**
 * Represents the text view for the image processor.
 */
public class ImageProcessingTextView implements ImageProcessingView {

  protected ImageProcessingModel model;
  protected Appendable out;

  /**
   * Constructor for the ImageProcessingTextView class that takes one argument.
   * @param model the Image Processing model.
   * @throws IllegalArgumentException if given model is null.
   */
  public ImageProcessingTextView(ImageProcessingModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Null model.");
    }
    this.model = model;
    this.out = System.out;
  }

  /**
   * Constructor for the ImageProcessingTextView class that take two parameters.
   * @param model the image processing model.
   * @param out the Appendable output.
   * @throws IllegalArgumentException if any given parameters are null.
   */
  public ImageProcessingTextView(ImageProcessingModel model, Appendable out)
          throws IllegalArgumentException {
    if (model == null || out == null) {
      throw new IllegalArgumentException("Null parameters");
    }
    this.model = model;
    this.out = out;
  }

  @Override
  public void writeMessage(String message) throws IOException {
    this.out.append(message);
  }
}
