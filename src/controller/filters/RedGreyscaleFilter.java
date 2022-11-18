package controller.filters;

/**
 * Represents a red greyscale filter that is applied to its image.
 */
public class RedGreyscaleFilter extends AColorFilter {

  /**
   * The constructor for the RedGreyscaleFilter class.
   *
   * @param imageName     the name of the image to greyscale.
   * @param destImageName the name of the new greyscaled image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public RedGreyscaleFilter(String imageName, String destImageName)
          throws IllegalArgumentException {
    super(imageName, destImageName);
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 1.0;
    this.values[0][1] = 0.0;
    this.values[0][2] = 0.0;
    this.values[1][0] = 1.0;
    this.values[1][1] = 0.0;
    this.values[1][2] = 0.0;
    this.values[2][0] = 1.0;
    this.values[2][1] = 0.0;
    this.values[2][2] = 0.0;
  }
}
