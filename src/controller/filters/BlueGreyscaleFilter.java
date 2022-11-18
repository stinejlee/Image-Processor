package controller.filters;

/**
 * A function object that applies a blue greyscale filter to an image.
 */
public class BlueGreyscaleFilter extends AColorFilter {

  /**
   * The constructor for the BlueGreyscaleFilter class.
   *
   * @param imageName     the name of the image file.
   * @param destImageName the desired name of the final, filtered image.
   * @throws IllegalArgumentException if any of given parameters are null.
   */
  public BlueGreyscaleFilter(String imageName, String destImageName)
          throws IllegalArgumentException {
    super(imageName, destImageName);
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 0.0;
    this.values[0][1] = 0.0;
    this.values[0][2] = 1.0;
    this.values[1][0] = 0.0;
    this.values[1][1] = 0.0;
    this.values[1][2] = 1.0;
    this.values[2][0] = 0.0;
    this.values[2][1] = 0.0;
    this.values[2][2] = 1.0;
  }
}
