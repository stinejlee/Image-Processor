package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import controller.filters.RedGreyscaleFilter;
import controller.imagecommands.Brighten;
import controller.imagecommands.HorizontalFlip;
import controller.imagecommands.ValueGreyscale;
import controller.imagecommands.VerticalFlip;
import controller.filters.BlueGreyscaleFilter;
import controller.filters.GaussianBlurFilter;
import controller.filters.GreenGreyscaleFilter;
import controller.filters.IntensityGreyscaleFilter;
import controller.filters.LumaGreyscaleFilter;
import controller.filters.SepiaFilter;
import controller.filters.SharpenFilter;
import controller.iocommands.Load;
import controller.iocommands.Save;
import model.ImageProcessingModel;
import model.ImageUtil;
import model.SaveType;
import view.ImageProcessingView;

/**
 * Represents the controller for the image processor. Allows the processor to react to inputs.
 */
public class ImageProcessingControllerImpl implements ImageProcessingController {
  private final Readable input;
  private final ImageProcessingView view;
  private ImageProcessingModel model;

  /**
   * The constructor for an ImageProcessingControllerImpl input script or interactive inputs.
   *
   * @param model the model to be processed.
   * @param view  the view to be
   * @param input the user input Readable.
   * @throws IllegalArgumentException if any of given parameters are null.
   */
  public ImageProcessingControllerImpl(ImageProcessingModel model, ImageProcessingView view,
                                       Readable input) throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("Null parameter given.");
    }
    this.model = model;
    this.view = view;
    this.input = input;
  }

  @Override
  public void processImages() throws IllegalStateException {
    Scanner sc = new Scanner(this.input);

    Map<String, Function<Scanner, ICommand>> knownCommands;

    knownCommands = new HashMap<>();
    knownCommands.put("-load", s -> new Load(sc.next(), sc.next()));
    knownCommands.put("-save", s -> new Save(sc.next(), sc.next()));
    knownCommands.put("-red-component", s -> new RedGreyscaleFilter(sc.next(), sc.next()));
    knownCommands.put("-green-component", s -> new GreenGreyscaleFilter(sc.next(), sc.next()));
    knownCommands.put("-blue-component", s -> new BlueGreyscaleFilter(sc.next(), sc.next()));
    knownCommands.put("-value-component", s -> new ValueGreyscale(sc.next(), sc.next()));
    knownCommands.put("-luma-component", s -> new LumaGreyscaleFilter(sc.next(), sc.next()));
    knownCommands.put("-intensity-component", s ->
            new IntensityGreyscaleFilter(sc.next(), sc.next()));
    knownCommands.put("-horizontal-flip", s -> new HorizontalFlip(sc.next(), sc.next()));
    knownCommands.put("-vertical-flip", s -> new VerticalFlip(sc.next(), sc.next()));
    knownCommands.put("-brighten", s -> new Brighten(sc.next(), sc.next(), sc.next()));
    knownCommands.put("-blur", s -> new GaussianBlurFilter(sc.next(), sc.next()));
    knownCommands.put("-sharpen", s -> new SharpenFilter(sc.next(), sc.next()));
    knownCommands.put("-sepia", s -> new SepiaFilter(sc.next(), sc.next()));

    this.tryWriteMessage("Commands available to use:\n" +
            "-load [image-path] [image-name]\n" +
            "-save [image-path] [image-name]\n" +
            "-(red-component, green-component, blue-component, value-component, " +
            "intensity-component, luma-component) [image-name] [dest-image-name]\n" +
            "-(horizontal-flip, vertical-flip) [image-name] [dest-image-name]\n" +
            "-brighten [increment] [image-name] [dest-image-name]\n" +
            "-blur [image-name] [dest-image-name]\n" +
            "-sharpen [image-name] [dest-image-name]\n" +
            "-sepia [image-name] [dest-image-name]\n");

    while (sc.hasNext()) {
      ICommand c;
      String in = sc.next();
      if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
        return;
      }
      Function<Scanner, ICommand> cmd =
              knownCommands.getOrDefault(in.toLowerCase(), null);
      if (cmd == null) {
        this.tryWriteMessage("Invalid command.\n");
      } else {
        c = cmd.apply(sc);
        try {
          c.execute(this.model);
          this.tryWriteMessage("Command Success!\n");
        } catch (IllegalArgumentException e) {
          c.execute(this);
          this.tryWriteMessage("Command Success!\n");
        }
      }
    }
    this.tryWriteMessage("Thank you for using the program!");
  }

  /**
   * Attempts to write the given message to the view, catches IOException and throws ISE.
   *
   * @param message the message to transmit to the Appendable.
   * @throws IllegalStateException if message fails to transmit.
   */
  private void tryWriteMessage(String message) throws IllegalStateException {
    try {
      this.view.writeMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to transmit to appendable.");
    }
  }

  @Override
  public void save(String fileName, String imageName, SaveType sType)
          throws IllegalArgumentException {
    switch (sType) {
      case ppm:
        ImageUtil.writePPM(fileName, this.model.getImage(imageName));
        break;
      case png:
        ImageUtil.writeConventional(fileName, this.model.getImage(imageName), "png");
        break;
      case jpg:
        ImageUtil.writeConventional(fileName, this.model.getImage(imageName), "jpg");
        break;
      case bmp:
        ImageUtil.writeConventional(fileName, this.model.getImage(imageName), "bmp");
        break;
      default:
        throw new IllegalArgumentException("Invalid save type");
    }
  }

  @Override
  public void loadImage(String fileName, String imageName, SaveType sType)
          throws IllegalArgumentException {
    switch (sType) {
      case ppm:
        this.model.addImage(imageName, ImageUtil.readPPM(fileName));
        break;
      case png:
      case bmp:
      case jpg:
        this.model.addImage(imageName, ImageUtil.readConventional(fileName));
        break;
      default:
        throw new IllegalArgumentException("Invalid save type");
    }
  }
}
