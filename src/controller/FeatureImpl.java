package controller;

import java.text.Bidi;

import controller.filters.BlueGreyscaleFilter;
import controller.filters.GaussianBlurFilter;
import controller.filters.GreenGreyscaleFilter;
import controller.filters.IntensityGreyscaleFilter;
import controller.filters.LumaGreyscaleFilter;
import controller.filters.RedGreyscaleFilter;
import controller.filters.SepiaFilter;
import controller.filters.SharpenFilter;
import controller.imagecommands.Brighten;
import controller.imagecommands.ValueGreyscale;
import model.ImageProcessingModel;
import view.ImageProcessingGUIView;

public class FeatureImpl implements Feature {

  private ImageProcessingModel model;
  private ImageProcessingGUIView view;

  public FeatureImpl(ImageProcessingModel model, ImageProcessingGUIView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Null arguments.");
    }
    this.model = model;
    this.view = view;
    this.view.setFeature(this);
  }
  @Override
  public void load() {

  }

  @Override
  public void save() {

  }

  @Override
  public void apply(String filter, int value) {
    switch (filter) {
      case "Blur":
        ICommand blur = new GaussianBlurFilter("test", "test");
        break;
      case "Sharpen":
        ICommand sharpen = new SharpenFilter("test", "test");
        break;
      case "Red Greyscale":
        ICommand redGS = new RedGreyscaleFilter("test", "test");
        break;
      case "Green Greyscale":
        ICommand greenGS = new GreenGreyscaleFilter("test", "test");
        break;
      case "Blue Greyscale":
        ICommand blueGS = new BlueGreyscaleFilter("test", "test");
        break;
      case "Intensity Greyscale":
        ICommand intensityGS = new IntensityGreyscaleFilter("test", "test");
        break;
      case "Value Greyscale":
        ICommand valueGS = new ValueGreyscale("test", "test");
        break;
      case "Luma Greyscale":
        ICommand lumaGS = new LumaGreyscaleFilter("test", "test");
        break;
      case "Sepia":
        ICommand sepia = new SepiaFilter("test","test");
        break;
      case "Brighten":
//        ICommand brighten = new Brighten(value, "test", "test");
        break;
      default:
        throw new IllegalArgumentException("Invalid filter.");
    }
  }
}
