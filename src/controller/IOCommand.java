package controller;

import model.ImageProcessingModel;

/**
 * Represents a file processing command.
 */
public interface IOCommand extends ICommand {
  default void execute(ImageProcessingModel model) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong execute.");
  }
}