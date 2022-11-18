import controller.IOCommand;
import controller.ImageProcessingCommand;
import controller.ImageProcessingController;
import model.Image;
import model.ImageProcessingModel;

/**
 * Abstract test class for a command.
 */
public abstract class ACommandTest {

  /**
   * Constructor for an ACommandTest.
   */
  public ACommandTest() {
    // abstract constructor not used
  }

  // Helper Method for testing execute with a ImageProcessingCommand
  public boolean testExecuteHelper(ImageProcessingCommand command, Image expectedImage,
                           String finalImageName, ImageProcessingModel model) {
    command.execute(model);
    return model.getImage(finalImageName).toString().equals(expectedImage.toString());
  }

  // Helper Method for testing execute with an IOCommand
  public boolean testExecuteHelper(IOCommand command, Image expectedImage, String finalImageName,
                                   ImageProcessingModel model,
                                   ImageProcessingController controller) {
    command.execute(controller);
    return model.getImage(finalImageName).toString().equals(expectedImage.toString());
  }
}
