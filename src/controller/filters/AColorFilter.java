package controller.filters;

import model.Image;
import model.ImageProcessingModel;


/**
 * Represents an abstract filter that manipulates colors which can be applied to an image.
 */
public abstract class AColorFilter extends AFilter {

  /**
   * The constructor for an AColorFilter.
   * @param imageName the name of the image the filter is being applied to.
   * @param destImageName the name of the new, filtered image.
   * @throws IllegalArgumentException if either inputs are null.
   */
  public AColorFilter(String imageName, String destImageName) throws IllegalArgumentException {
    super(imageName, destImageName);
    this.values = new double[3][3];
  }

  @Override
  public void execute(ImageProcessingModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Null parameters.");
    }
    Image newImage = model.getImage(this.imageName).applyColorFilter(this);
    model.addImage(this.destImageName, newImage);
  }
}
