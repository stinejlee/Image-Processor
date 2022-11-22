package model;

import controller.IFilter;
import controller.filters.AColorFilter;

public interface IImage {

  /**
   * An enum that represents the type of greyscale filter being applied.
   */
  enum GreyscaleType {
    Red, Blue, Green, Value, Luma, Intensity
  }

  /**
   * An enum that represents the type of flip filter being applies.
   */
  enum FlipType {
    Horizontal, Vertical
  }

  /**
   * Returns the height of this image.
   * @return the height of this image.
   */
  int getHeight();

  /**
   * Returns the width of this image.
   * @return the width of this image.
   */
  int getWidth();
  @Override
  String toString();

  /**
   * Returns the pixel at the given location from this image.
   * @param row the row location of the pixel
   * @param col the column location of the pixel
   * @return the Pixel from this Image.
   */
  Pixel getPixelAt(int row, int col);

  /**
   * Greyscales this image based on the given greyscale type.
   *
   * @param gsType the type of greyscale filter being applied.
   * @return the new greyscaled image.
   * @throws IllegalArgumentException if an invalid greyscale type is given.
   */
  Image greyScale(GreyscaleType gsType) throws IllegalArgumentException;

  /**
   * Flips this image based on the given flip type.
   *
   * @param flipType the type of flip filter being applied.
   * @return the new flipped image.
   * @throws IllegalArgumentException if an invalid flip type is given.
   */
  Image flip(FlipType flipType) throws IllegalArgumentException;

  /**
   * Brightens this image by the given increment.
   *
   * @param increment the increment by which the image is brightened or darkened.
   *                  Positive increment brightens, negative increment darkens.
   * @return the new brightened image.
   */
  Image brighten(int increment);

  /**
   * Applies the given IFilter this image.
   *
   * @param filter the IFilter that is being applied to this image.
   * @return a new, filtered image.
   */
  Image applyFilter(IFilter filter);

  /**
   * Applies the given color filter to this image.
   *
   * @param colorFilter the color transformation being applied
   * @return a new Image that is the filtered version of this image.
   */
  Image applyColorFilter(AColorFilter colorFilter);
}
