package controller.filters;

/**
 * Represents an intensity greyscale filter.
 */
public class IntensityGreyscaleFilter extends AColorFilter {
  /**
   * Constructor for the IntensityGreyscaleFilter class.
   *
   * @param imageName     the name of the image to apply the greyscale to.
   * @param destImageName the name of the new greyscaled image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public IntensityGreyscaleFilter(String imageName, String destImageName)
          throws IllegalArgumentException {
    super(imageName, destImageName);
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 1.0 / 3.0;
    this.values[0][1] = 1.0 / 3.0;
    this.values[0][2] = 1.0 / 3.0;
    this.values[1][0] = 1.0 / 3.0;
    this.values[1][1] = 1.0 / 3.0;
    this.values[1][2] = 1.0 / 3.0;
    this.values[2][0] = 1.0 / 3.0;
    this.values[2][1] = 1.0 / 3.0;
    this.values[2][2] = 1.0 / 3.0;
  }
}
