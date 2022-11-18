package controller;

import model.SaveType;

/**
 * This interface represents the operations offered by the
 * controller for the image processor.
 */
public interface ImageProcessingController {

  /**
   * Processes inputs from the user and applies processes images based on those inputs.
   *
   * @throws IllegalStateException if controller is unable to read input or transmit output
   */
  void processImages() throws IllegalStateException;

  /**
   * Saves the image in the given type with the given image name as the given file name.
   *
   * @param fileName  the name to save the image as.
   * @param imageName the name of the image in the map.
   * @param sType     the type of file to be saved.
   */
  void save(String fileName, String imageName, SaveType sType);

  /**
   * Loads am image from a filepath.
   *
   * @param fileName  the filepath name.
   * @param imageName the name the image will be mapped under.
   * @param sType     the type of file to be loaded.
   */
  void loadImage(String fileName, String imageName, SaveType sType);

}
