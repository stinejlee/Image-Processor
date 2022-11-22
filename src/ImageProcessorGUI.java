import controller.Feature;
import controller.FeatureImpl;
import controller.ImageProcessingController;
import controller.ImageProcessingControllerGUI;
import controller.ImageProcessingControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.ImageProcessingModelState;
import view.ImageProcessingGUIView;
import view.ImageProcessingView;
import view.ImageProcessingGUIViewImpl;

public class ImageProcessorGUI {
  public static void main(String[] args) {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageProcessingGUIView view = new ImageProcessingGUIViewImpl();
    Feature feature = new FeatureImpl(model, view);
  }
}
