package controller.filters;

/**
 * A function object that applies a sepia greyscale filter to an image.
 */
public class SepiaFilter extends AColorFilter {

  /**
   * Constructor for the SepiaFilter class.
   *
   * @param imageName     the name of the image to apply the sepia filter.
   * @param destImageName the name of the new sepia toned image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public SepiaFilter(String imageName, String destImageName) throws IllegalArgumentException {
    super(imageName, destImageName);
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 0.393;
    this.values[0][1] = 0.769;
    this.values[0][2] = 0.189;
    this.values[1][0] = 0.349;
    this.values[1][1] = 0.686;
    this.values[1][2] = 0.168;
    this.values[2][0] = 0.272;
    this.values[2][1] = 0.534;
    this.values[2][2] = 0.131;
  }

}
