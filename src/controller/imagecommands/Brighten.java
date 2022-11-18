package controller.imagecommands;

import controller.ImageProcessingCommand;
import model.Image;
import model.ImageProcessingModel;

/**
 * The function object that brightens (or darkens) an image.
 */
public class Brighten implements ImageProcessingCommand {
  private int increment;
  private String imageName;
  private String destImageName;

  /**
   * Constructor for the Brighten class.
   *
   * @param increment     the increment by which the image is brightened.
   * @param imageName     the name of the image to be brightened.
   * @param destImageName the name of the new brightened image.
   * @throws IllegalArgumentException if any of given parameters are null.
   */
  public Brighten(String increment, String imageName, String destImageName)
          throws IllegalArgumentException {
    try {
      Integer.parseInt(increment);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Illegal Arguments");
    }
    if (Integer.parseInt(increment) == 0 || increment == null ||
            imageName == null || destImageName == null) {
      throw new IllegalArgumentException("Illegal Arguments");
    }
    this.increment = Integer.parseInt(increment);
    this.imageName = imageName;
    this.destImageName = destImageName;
  }

  @Override
  public void execute(ImageProcessingModel model) throws IllegalArgumentException {
    Image newImage = model.getImage(this.imageName).brighten(increment);
    model.addImage(this.destImageName, newImage);
  }
}
