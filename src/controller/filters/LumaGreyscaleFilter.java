package controller.filters;

/**
 * Represents a luma greyscale filter that is applied to its image.
 */
public class LumaGreyscaleFilter extends AColorFilter  {

  /**
   * Constructor for the LumaGreyscaleFilter class.
   *
   * @param imageName     the name of the image to greyscale.
   * @param destImageName the name of the new greyscaled image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public LumaGreyscaleFilter(String imageName, String destImageName)
          throws IllegalArgumentException {
    super(imageName, destImageName);
    this.initValues();
  }

  @Override
  public void initValues() {
    this.values[0][0] = 0.2126;
    this.values[0][1] = 0.7152;
    this.values[0][2] = 0.0722;
    this.values[1][0] = 0.2126;
    this.values[1][1] = 0.7152;
    this.values[1][2] = 0.0722;
    this.values[2][0] = 0.2126;
    this.values[2][1] = 0.7152;
    this.values[2][2] = 0.0722;
  }
}
