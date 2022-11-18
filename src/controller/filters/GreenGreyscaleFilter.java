package controller.filters;

/**
 * The green greyscale function object that gets applied to its image.
 */
public class GreenGreyscaleFilter extends AColorFilter {

  /**
   * Constructor for the GreenGreyscaleFilter class.
   *
   * @param imageName     the name of the image to greyscale.
   * @param destImageName the name of the new greyscaled image.
   * @throws IllegalArgumentException if any of given parameters are null.
   */
  public GreenGreyscaleFilter(String imageName, String destImageName)
          throws IllegalArgumentException {
    super(imageName, destImageName);
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 0.0;
    this.values[0][1] = 1.0;
    this.values[0][2] = 0.0;
    this.values[1][0] = 0.0;
    this.values[1][1] = 1.0;
    this.values[1][2] = 0.0;
    this.values[2][0] = 0.0;
    this.values[2][1] = 1.0;
    this.values[2][2] = 0.0;
  }
}
