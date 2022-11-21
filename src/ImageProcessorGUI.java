import controller.ImageProcessingController;
import controller.ImageProcessingControllerGUI;
import controller.ImageProcessingControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.ImageProcessingModelState;
import view.ImageProcessingView;
import view.ImageProcessingGUIViewImpl;

public class ImageProcessorGUI {
  public static void main(String[] args) {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageProcessingView view = new ImageProcessingGUIViewImpl(model);
    ImageProcessingController controller = new ImageProcessingControllerGUI(model, view);
  }
}
