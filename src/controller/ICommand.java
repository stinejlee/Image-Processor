package controller;

import model.ImageProcessingModel;

/**
 * Represents a command.
 */
public interface ICommand {
  /**
   * Applies this filter to an image from the given model.
   *
   * @param model the given image processing model.
   */
  void execute(ImageProcessingModel model) throws IllegalArgumentException;

  /**
   * Applies this filter to an image from the given controller.
   *
   * @param controller the given image processing controller.
   */
  void execute(ImageProcessingController controller) throws IllegalArgumentException;
}
