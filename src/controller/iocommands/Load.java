package controller.iocommands;

import controller.IOCommand;
import controller.ImageProcessingController;
import model.SaveType;

/**
 * Represents the load function object that loads an image from a file path.
 */
public class Load implements IOCommand {
  private String imagePath;
  private String imageName;
  private SaveType sType;

  /**
   * Constructor for the Load class.
   *
   * @param imagePath the path of the image file
   * @param imageName the name of the loaded image
   * @throws IllegalArgumentException if any of the given parameters are null
   */
  public Load(String imagePath, String imageName) throws IllegalArgumentException {
    if (imagePath == null || imageName == null) {
      throw new IllegalArgumentException("Illegal Arguments");
    }
    this.imagePath = imagePath;
    this.imageName = imageName;
    if (this.imagePath.contains(".bmp")) {
      this.sType = SaveType.bmp;
    } else if (this.imagePath.contains(".jpg")) {
      this.sType = SaveType.jpg;
    } else if (this.imagePath.contains(".png")) {
      this.sType = SaveType.png;
    } else if (this.imagePath.contains(".ppm")) {
      this.sType = SaveType.ppm;
    } else {
      throw new IllegalArgumentException("Unsupported filetype.");
    }
  }

  @Override
  public void execute(ImageProcessingController controller) throws IllegalArgumentException {
    controller.loadImage(this.imagePath, this.imageName, sType);
  }
}
