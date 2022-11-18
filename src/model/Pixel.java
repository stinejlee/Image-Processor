package model;

/**
 * Represents a single pixel in an image with rgb color components valued between 0 and 255.
 */
public class Pixel {

  private final int red;
  private final int green;
  private final int blue;

  private final int value;
  private final int intensity;
  private final int luma;

  /**
   * The constructor for the Pixel class.
   *
   * @param r the red color value between 0-255.
   * @param g the green color value between 0-255.
   * @param b the blue color value between 0-255.
   */
  public Pixel(int r, int g, int b) throws IllegalArgumentException {
    if (r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) {
      throw new IllegalArgumentException("Color values must be between 0 and 255, inclusive.");
    }
    this.red = r;
    this.green = g;
    this.blue = b;
    this.value = Integer.max(r, Integer.max(g, b));
    this.intensity = (r + g + b) / 3;
    this.luma = (int) Math.round(0.2126 * r + 0.7152 * g + 0.0722 * b);
  }

  /**
   * Returns the red value of this Pixel.
   */
  public int getRed() {
    int r = this.red;
    return r;
  }

  /**
   * Returns the green value of this Pixel.
   */
  public int getGreen() {
    int g = this.green;
    return g;
  }

  /**
   * Returns the blue value of this Pixel.
   */
  public int getBlue() {
    int b = this.blue;
    return b;
  }

  /**
   * Returns the value int of this Pixel.
   */
  public int getValue() {
    int val = this.value;
    return val;
  }

  /**
   * Returns the intensity value of this Pixel.
   */
  public int getIntensity() {
    int i = this.intensity;
    return i;
  }

  /**
   * Returns the luma value of this Pixel.
   */
  public int getLuma() {
    int lum = this.luma;
    return lum;
  }
}
