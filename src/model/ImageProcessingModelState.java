package model;


/**
 * Represents the current state of a model.
 */
public interface ImageProcessingModelState {
  /**
   * Gets the image with the given filename from the map.
   *
   * @param imageName the name of the image.
   */
  Image getImage(String imageName);
}
