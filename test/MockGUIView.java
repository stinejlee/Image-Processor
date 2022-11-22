import java.awt.image.BufferedImage;
import java.io.IOException;

import controller.Feature;
import model.ImageProcessingModel;
import view.ImageProcessingGUIView;

/**
 * Mock GUIView for testing purposes.
 */
public class MockGUIView implements ImageProcessingGUIView {
  private StringBuilder actions;

  public MockGUIView() {
    this.actions = new StringBuilder();
  }

  /**
   * Method for testing if the action StringBuilder contains a string after running a method.
   *
   * @param s the string to look for
   * @return true if found, false if not
   */
  public boolean actionRun(String s) {
    return actions.toString().contains(s);
  }

  @Override
  public void setFeature(Feature feature) {
    this.actions.append("feature set");
  }

  @Override
  public String loadImage() {
    return "res/Koala.ppm";
  }

  @Override
  public void setCurrentImage(BufferedImage image) {
    this.actions.append("image set");
  }

  @Override
  public String saveImage() {
    return "res/newKoala.ppm";
  }

  @Override
  public void resetImagePanel() {
    this.actions.append("reset image");
  }

  @Override
  public void resetHistPanels() {
    this.actions.append("reset histograms");
  }

  @Override
  public void writeMessage(String message) throws IOException {

  }
}
