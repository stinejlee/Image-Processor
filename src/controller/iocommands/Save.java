package controller.iocommands;

import controller.IOCommand;
import controller.ImageProcessingController;
import model.SaveType;

/**
 * Represents the save function that saves its image to its imagepath.
 */
public class Save implements IOCommand {
  private String imagePath;
  private String imageName;
  private SaveType sType;

  /**
   * Constructor for the Save class.
   *
   * @param imagePath the image path that the image will be saved to.
   * @param imageName the name of the image that will be saved.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public Save(String imagePath, String imageName) throws IllegalArgumentException {
    if (imagePath == null || imageName == null) {
      throw new IllegalArgumentException("Illegal Arguments");
    }
    this.imagePath = imagePath;
    this.imageName = imageName;
    if (this.imagePath.contains(".bmp")) {
      this.sType = SaveType.bmp;
    }
    else if (this.imagePath.contains(".jpg")) {
      this.sType = SaveType.jpg;
    }
    else if (this.imagePath.contains(".png")) {
      this.sType = SaveType.png;
    }
    else if (this.imagePath.contains(".ppm")) {
      this.sType = SaveType.ppm;
    }
    else {
      throw new IllegalArgumentException("Unsupported filetype.");
    }
  }

  @Override
  public void execute(ImageProcessingController controller) throws IllegalArgumentException {
    controller.save(this.imagePath, this.imageName, sType);
  }
}