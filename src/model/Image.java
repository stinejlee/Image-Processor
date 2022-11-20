package model;

// import com.sun.glass.ui.Pixels;

import controller.IFilter;
import controller.filters.AColorFilter;

/**
 * Represents an Image that contains pixels and has dimensions.
 */
public class Image implements IImage {
  protected final int width;
  protected final int height;
  private final Pixel[][] pixels;

  /**
   * Constructor for the Image class, automatically calculates the dimensions based on given pixels.
   *
   * @param pixels the pixels in the image.
   * @throws IllegalStateException if null parameter is given.
   */
  public Image(Pixel[][] pixels) throws IllegalStateException {
    if (pixels == null) {
      throw new IllegalArgumentException("No null arguments.");
    }
    this.pixels = pixels;
    this.width = pixels[0].length;
    this.height = pixels.length;
  }

  @Override
  public int getHeight() {
    return this.pixels.length;
  }

  @Override
  public int getWidth() {
    return this.pixels[0].length;
  }

  // Method that outputs all pixels and values, for testing
  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        ans.append(pixels[i][j].getRed() + ", "
                + pixels[i][j].getGreen() + ", "
                + pixels[i][j].getBlue() + "|");
      }
      ans.append("\n");
    }
    return ans.toString();
  }

  @Override
  public Pixel getPixelAt(int row, int col) {
    return new Pixel(this.pixels[row][col].getRed(),
            this.pixels[row][col].getGreen(), this.pixels[row][col].getBlue());
  }

  @Override
  public Image greyScale(GreyscaleType gsType) throws IllegalArgumentException {
    Pixel[][] newPixels = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        int c;
        switch (gsType) {
          case Red:
            c = this.getPixelAt(i, j).getRed();
            break;
          case Green:
            c = this.getPixelAt(i, j).getGreen();
            break;
          case Blue:
            c = this.getPixelAt(i, j).getBlue();
            break;
          case Value:
            c = this.getPixelAt(i, j).getValue();
            break;
          case Luma:
            c = this.getPixelAt(i, j).getLuma();
            break;
          case Intensity:
            c = this.getPixelAt(i, j).getIntensity();
            break;
          default:
            throw new IllegalArgumentException("Invalid greyscale type");
        }
        newPixels[i][j] = new Pixel(c, c, c);
      }
    }
    return new Image(newPixels);
  }

  @Override
  public Image flip(FlipType flipType) throws IllegalArgumentException {
    Pixel[][] newPixels = new Pixel[this.height][this.width];
    switch (flipType) {
      case Horizontal:
        for (int i = 0; i < this.height; i++) {
          for (int j = this.width - 1; j >= 0; j--) {
            newPixels[i][this.width - 1 - j] = this.getPixelAt(i, j);
          }
        }
        break;
      case Vertical:
        for (int i = this.height - 1; i >= 0; i--) {
          for (int j = 0; j < this.width; j++) {
            newPixels[this.height - 1 - i][j] = this.getPixelAt(i, j);
          }
        }
        break;
      default:
        throw new IllegalArgumentException("Invalid flip type");
    }
    return new Image(newPixels);
  }

  @Override
  public Image brighten(int increment) {
    Pixel[][] newPixels = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        int r = Math.max(0, Math.min(this.getPixelAt(i, j).getRed() + increment, 255));
        int g = Math.max(0, Math.min(this.getPixelAt(i, j).getGreen() + increment, 255));
        int b = Math.max(0, Math.min(this.getPixelAt(i, j).getBlue() + increment, 255));
        newPixels[i][j] = new Pixel(r, g, b);
      }
    }
    return new Image(newPixels);
  }

  @Override
  public Image applyFilter(IFilter filter) {
    int centerRow = filter.getHeight() / 2;
    int centerCol = filter.getWidth() / 2;
    Pixel[][] newPixels = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        Pixel[][] imageSegment = new Pixel[filter.getHeight()][filter.getWidth()];
        for (int r = 0; r < filter.getHeight(); r++) {
          for (int c = 0; c < filter.getWidth(); c++) {
            try {
              imageSegment[r][c] =
                      new Pixel(this.pixels[i - (centerRow - r)][j - (centerCol - c)].getRed(),
                              this.pixels[i - (centerRow - r)][j - (centerCol - c)].getGreen(),
                              this.pixels[i - (centerRow - r)][j - (centerCol - c)].getBlue());
            } catch (IndexOutOfBoundsException e) {
              imageSegment[r][c] = new Pixel(0, 0, 0);
            }
          }
        }
        newPixels[i][j] = this.applyFilterHelp(imageSegment, filter);
      }
    }
    return new Image(newPixels);
  }

  /**
   * Applies the filter to the given image segment (group of pixels),
   * helper for the applyFilter method.
   *
   * @param imageSegment the segment of the image that the
   *                     filter is being applied to (same size as the filter size)
   * @param filter       the filter being applied
   * @return the new filtered pixel.
   */
  private Pixel applyFilterHelp(Pixel[][] imageSegment, IFilter filter) {
    double redSum = 0.0;
    double greenSum = 0.0;
    double blueSum = 0.0;
    for (int i = 0; i < filter.getHeight(); i++) {
      for (int j = 0; j < filter.getWidth(); j++) {
        redSum += imageSegment[i][j].getRed() * filter.getValueAt(i, j);
        greenSum += imageSegment[i][j].getGreen() * filter.getValueAt(i, j);
        blueSum += imageSegment[i][j].getBlue() * filter.getValueAt(i, j);
      }
    }
    int r = Math.max(0, Math.min(((int) Math.round(redSum)), 255));
    int g = Math.max(0, Math.min(((int) Math.round(greenSum)), 255));
    int b = Math.max(0, Math.min(((int) Math.round(blueSum)), 255));

    return new Pixel(r, g, b);
  }

  @Override
  public Image applyColorFilter(AColorFilter colorFilter) {
    Pixel[][] newPixels = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        newPixels[i][j] = this.applyColorFilterHelp(this.pixels[i][j], colorFilter);
      }
    }
    return new Image(newPixels);
  }

  /**
   * Applies the given colorFilter to the given Pixel.
   *
   * @param pix         the pixel being filtered.
   * @param colorFilter the color transformation being applied.
   * @return the new filtered pixel.
   */

  private Pixel applyColorFilterHelp(Pixel pix, AColorFilter colorFilter) {
    double[] colorSums = {0.0, 0.0, 0.0};
    for (int i = 0; i < colorFilter.getHeight(); i++) {
      colorSums[i] += pix.getRed() * colorFilter.getValueAt(i, 0);
      colorSums[i] += pix.getGreen() * colorFilter.getValueAt(i, 1);
      colorSums[i] += pix.getBlue() * colorFilter.getValueAt(i, 2);
    }
    int r = Math.max(0, Math.min(((int) Math.round(colorSums[0])), 255));
    int g = Math.max(0, Math.min(((int) Math.round(colorSums[1])), 255));
    int b = Math.max(0, Math.min(((int) Math.round(colorSums[2])), 255));

    return new Pixel(r, g, b);
  }
}
