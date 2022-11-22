package model;

/**
 * Represents the model for the image processor.
 */
public interface ImageProcessingModel extends ImageProcessingModelState {

  /**
   * Adds the given image to this model's image map.
   *
   * @param imageName the name to map the image under.
   * @param image     the image being mapped.
   */
  void addImage(String imageName, Image image);

}
