package controller.imagecommands;

import controller.ImageProcessingCommand;
import model.Image;
import model.ImageProcessingModel;

/**
 * Represents a vertical flip filter that is applied to its image.
 */
public class VerticalFlip implements ImageProcessingCommand {
  private String imageName;
  private String destImageName;

  /**
   * The constructor for the VerticalFlip class.
   *
   * @param imageName     the name of the image to be flipped.
   * @param destImageName the name of the new flipped image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public VerticalFlip(String imageName, String destImageName) throws IllegalArgumentException {
    if (imageName == null || destImageName == null) {
      throw new IllegalArgumentException("Illegal Arguments");
    }
    this.imageName = imageName;
    this.destImageName = destImageName;
  }

  @Override
  public void execute(ImageProcessingModel model) throws IllegalArgumentException {
    Image newImage = model.getImage(this.imageName).flip(Image.FlipType.Vertical);
    model.addImage(this.destImageName, newImage);
  }
}
