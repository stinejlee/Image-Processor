package controller.imagecommands;

import controller.ImageProcessingCommand;
import model.Image;
import model.ImageProcessingModel;

/**
 * Represents a value greyscale filter that applies to its image.
 */
public class ValueGreyscale implements ImageProcessingCommand {
  private String imageName;
  private String destImageName;

  /**
   * Constructor for the ValueGreyscale class.
   *
   * @param imageName     the name of the image to greyscale.
   * @param destImageName the name of the new greyscaled image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public ValueGreyscale(String imageName, String destImageName) throws IllegalArgumentException {
    if (imageName == null || destImageName == null) {
      throw new IllegalArgumentException("Illegal Arguments");
    }
    this.imageName = imageName;
    this.destImageName = destImageName;
  }

  @Override
  public void execute(ImageProcessingModel model) throws IllegalArgumentException {
    Image newImage = model.getImage(this.imageName).greyScale(Image.GreyscaleType.Value);
    model.addImage(this.destImageName, newImage);
  }
}
