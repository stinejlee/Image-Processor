import controller.Feature;
import controller.FeatureImpl;
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
    Feature feature = new FeatureImpl();
    ImageProcessingView view = new ImageProcessingGUIViewImpl(feature);
    ImageProcessingController controller = new ImageProcessingControllerGUI(model, view);
  }
}
