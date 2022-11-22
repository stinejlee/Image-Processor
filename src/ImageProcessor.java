
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.Feature;
import controller.FeatureImpl;
import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageProcessingGUIView;
import view.ImageProcessingGUIViewImpl;
import view.ImageProcessingTextView;
import view.ImageProcessingView;

/**
 * Executes the image processor program.
 */
public class ImageProcessor {
  /**
   * Main method that simulates running the Image Processing program.
   *
   * @param args represents the user's inputs
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      ImageProcessingModel model = new ImageProcessingModelImpl();
      ImageProcessingGUIView view = new ImageProcessingGUIViewImpl();
      Feature feature = new FeatureImpl(model, view);
    }
    else {
      ImageProcessingModel model = new ImageProcessingModelImpl();
      ImageProcessingView view = new ImageProcessingTextView(model);
      if (args[0].equals("-text")) {
        Readable rd = new InputStreamReader(System.in);
        ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, rd);
        controller.processImages();
      }
      else if (args[0].equals("-file")) {
        try {
          Readable rd =
                  new InputStreamReader(new ByteArrayInputStream(readFile(args[1]).getBytes()));
          ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, rd);
          controller.processImages();
        } catch (IllegalArgumentException e) {
          System.out.println("Failed to read file.");
        }
      }
    }
  }

  private static String readFile(String fileName) throws IllegalArgumentException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File " + fileName + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      builder.append(s + System.lineSeparator());
    }

    return builder.toString();
  }
}
