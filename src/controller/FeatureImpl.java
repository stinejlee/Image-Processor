package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;

import controller.filters.BlueGreyscaleFilter;
import controller.filters.GaussianBlurFilter;
import controller.filters.GreenGreyscaleFilter;
import controller.filters.IntensityGreyscaleFilter;
import controller.filters.LumaGreyscaleFilter;
import controller.filters.RedGreyscaleFilter;
import controller.filters.SepiaFilter;
import controller.filters.SharpenFilter;
import controller.imagecommands.Brighten;
import controller.imagecommands.HorizontalFlip;
import controller.imagecommands.ValueGreyscale;
import controller.imagecommands.VerticalFlip;
import model.IImage;
import model.Image;
import model.ImageProcessingModel;
import model.ImageUtil;
import view.ImageProcessingGUIView;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * An implementation of the Feature interface that interacts with a ImageProcessingGUIView and
 * an ImageProcessingModel.
 */
public class FeatureImpl implements Feature {

  private ImageProcessingModel model;
  private ImageProcessingGUIView view;

  /**
   * The constructor for the FeatureImpl class that takes in the model and the view, and sets the
   * view's feature as this.
   * @param model the image processing model.
   * @param view the GUI view of the image processor.
   */
  public FeatureImpl(ImageProcessingModel model, ImageProcessingGUIView view)
          throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Null arguments.");
    }
    this.model = model;
    this.view = view;
    this.view.setFeature(this);
  }

  @Override
  public void load() {
    String filepath = this.view.loadImage();

    Image image;
    if (filepath.endsWith("ppm")) {
      image = ImageUtil.readPPM(filepath);
    }
    else {
      image = ImageUtil.readConventional(filepath);
    }
    this.model.addImage("test", image);

    this.updateViewImage(image);
  }

  /**
   * Updates the current image in the view.
   * @param image the new image that should appear in the view.
   */
  private void updateViewImage(IImage image) {
    BufferedImage pic = new BufferedImage(image.getWidth(), image.getHeight(), TYPE_INT_RGB);

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int r = image.getPixelAt(i, j).getRed();
        int g = image.getPixelAt(i, j).getGreen();
        int b = image.getPixelAt(i, j).getBlue();
        Color color = new Color(r,g,b);
        pic.setRGB(j,i, color.getRGB());
      }
    }

    this.view.setCurrentImage(pic);
    this.view.resetImagePanel();
    this.view.resetHistPanels();
  }

  @Override
  public void save() {
    String filepath = this.view.saveImage();
    if (filepath.endsWith("ppm")) {
      ImageUtil.writePPM(filepath, this.model.getImage("test"));
    }
    else {
      ImageUtil.writeConventional(filepath, this.model.getImage("test"),
              filepath.substring(filepath.length() - 3));
    }
  }

  @Override
  public void apply(String filter, int value) {
    ICommand cmd;
    switch (filter) {
      case "Blur":
        cmd = new GaussianBlurFilter("test", "test");
        break;
      case "Sharpen":
        cmd = new SharpenFilter("test", "test");
        break;
      case "Red Greyscale":
        cmd = new RedGreyscaleFilter("test", "test");
        break;
      case "Green Greyscale":
        cmd = new GreenGreyscaleFilter("test", "test");
        break;
      case "Blue Greyscale":
        cmd = new BlueGreyscaleFilter("test", "test");
        break;
      case "Intensity Greyscale":
        cmd = new IntensityGreyscaleFilter("test", "test");
        break;
      case "Value Greyscale":
        cmd = new ValueGreyscale("test", "test");
        break;
      case "Luma Greyscale":
        cmd = new LumaGreyscaleFilter("test", "test");
        break;
      case "Sepia":
        cmd = new SepiaFilter("test","test");
        break;
      case "Brighten":
        cmd = new Brighten(Integer.toString(value), "test", "test");
        break;
      case "Horizontal Flip":
        cmd = new HorizontalFlip("test", "test");
        break;
      case "Vertical Flip":
        cmd = new VerticalFlip("test", "test");
        break;
      default:
        throw new IllegalArgumentException("Invalid filter.");
    }
    cmd.execute(this.model);

    this.updateViewImage(this.model.getImage("test"));

  }
}
