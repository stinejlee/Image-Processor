package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an implementation of the ImageProcessModel that has all methods implemented.
 */
public class ImageProcessingModelImpl implements ImageProcessingModel {

  Map<String, Image> images;

  /**
   * Default constructor for the ImageProcessingModelImpl class.
   */
  public ImageProcessingModelImpl() {
    images = new HashMap<>();
  }

  /**
   * A constructor for the ImageProcessModel class that takes a map.
   *
   * @param images the collection of images.
   * @throws IllegalArgumentException if the given map is null.
   */
  public ImageProcessingModelImpl(Map<String, Image> images) {
    if (images == null) {
      throw new IllegalArgumentException("Null parameters");
    }
    this.images = new HashMap<String, Image>(images);
  }

  @Override
  public void addImage(String imageName, Image image) {
    this.images.put(imageName, image);
  }

  @Override
  public Image getImage(String imageName) {
    if (!this.images.containsKey(imageName)) {
      throw new IllegalArgumentException("image does not exist");
    } else {
      return this.images.get(imageName);
    }
  }
}
