package controller.filters;

import controller.IFilter;
import model.Image;
import model.ImageProcessingModel;

/**
 * Represents an abstract filter that that can be applied to an image.
 */
public abstract class AFilter implements IFilter {
  double[][] values;
  String imageName;
  String destImageName;

  /**
   * Constructor for an abstract filter.
   *
   * @param imageName the name of the image that the filter is to be applied.
   * @param destImageName the name of the new filtered image.
   * @throws IllegalArgumentException if any of given parameters are null.
   */
  public AFilter(String imageName, String destImageName) throws IllegalArgumentException {
    if (imageName == null || destImageName == null) {
      throw new IllegalArgumentException("Null parameters.");
    }
    this.imageName = imageName;
    this.destImageName = destImageName;
  }

  /**
   * Initializes the value matrix and fills in the values according to the type of filter.
   */
  public abstract void initValues();

  @Override
  public double getValueAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > values.length || col < 0 || col > values[0].length) {
      throw new IllegalArgumentException("Out of bounds.");
    }
    return this.values[row][col];
  }

  @Override
  public int getWidth() {
    return this.values[0].length;
  }

  @Override
  public int getHeight() {
    return this.values.length;
  }

  @Override
  public void execute(ImageProcessingModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Null parameters.");
    }
    Image newImage = model.getImage(this.imageName).applyFilter(this);
    model.addImage(this.destImageName, newImage);
  }
}
