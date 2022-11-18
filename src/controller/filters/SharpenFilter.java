package controller.filters;

/**
 * A function object that applies a sharpen filter to an image.
 */
public class SharpenFilter extends AFilter {

  /**
   * Constructor for the SharpenFilter class.
   *
   * @param imageName     the name of the image to apply the sharpen filter.
   * @param destImageName the name of the new sharpened image.
   * @throws IllegalArgumentException if any of the given parameters are null.
   */
  public SharpenFilter(String imageName, String destImageName) throws IllegalArgumentException {
    super(imageName, destImageName);
    this.values = new double[5][5];
    this.initValues();
  }

  @Override
  public void initValues() {
    for (int i  = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i == 0 || i == 4 || j == 0 || j == 4) {
          this.values[i][j] = -1.0 / 8;
        }
        else if (i == 1 || i  == 3 || j == 1 || j == 3) {
          this.values[i][j] = 1.0 / 4;
        }
        else {
          this.values[i][j] = 1.0;
        }
      }
    }
  }

}
