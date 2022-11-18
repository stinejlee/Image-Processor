package model;

/**
 * Represents the model for the image processor.
 */
public interface ImageProcessingModel {

  /**
   * Adds the given image to this model's image map.
   *
   * @param imageName the name to map the image under.
   * @param image     the image being mapped.
   */
  void addImage(String imageName, Image image);

  /**
   * Gets the image with the given filename from the map.
   *
   * @param imageName the name of the image.
   */
  Image getImage(String imageName);

}
