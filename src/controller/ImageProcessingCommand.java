package controller;

/**
 * Represents an image filter command.
 */
public interface ImageProcessingCommand extends ICommand {
  default void execute(ImageProcessingController controller) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong execute");
  }
}
