package controller;

import controller.filters.GaussianBlurFilter;
import controller.filters.SharpenFilter;
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
        break;
      case "Green Greyscale":
        break;
      case "Blue Greyscale":
        break;
      case "Intensity Greyscale":
        break;
      case "Value Greyscale":
        break;
      case "Luma Greyscale":
        break;
      case "Sepia":
        break;
      case "Brighten":
        break;
      default:
        throw new IllegalArgumentException("Invalid filter.");
    }
  }
}
