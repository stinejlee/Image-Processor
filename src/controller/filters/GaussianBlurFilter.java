package controller.filters;

/**
 * A function object that applies a gaussian blur filter to an image.
 */
public class GaussianBlurFilter extends AFilter {

  /**
   * Constructor for the GaussianBlurFilter class.
   *
   * @param imageName     the name of the image to apply the blur filter.
   * @param destImageName the name of the new blurred image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public GaussianBlurFilter(String imageName, String destImageName)
          throws IllegalArgumentException {
    super(imageName, destImageName);
    this.values = new double[3][3];
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 1.0 / 16.0;
    this.values[0][1] = 1.0 / 8.0;
    this.values[0][2] = 1.0 / 16.0;
    this.values[1][0] = 1.0 / 8.0;
    this.values[1][1] = 1.0 / 4.0;
    this.values[1][2] = 1.0 / 8.0;
    this.values[2][0] = 1.0 / 16.0;
    this.values[2][1] = 1.0 / 8.0;
    this.values[2][2] = 1.0 / 16.0;
  }
}
