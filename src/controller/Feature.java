package controller;

/**
 * Represents a controller for the GUI that handles command callbacks and links the interactions
 * between the model and the view.
 */
public interface Feature {

  /**
   * Gets called by the view when the load image is clicked, which loads an image to the model
   * based on a file selected by the user in the view.
   */
  void load();

  /**
   * Gets called by the view when the save button is clicked, which saves an image as a file
   * based on the user's desired filepath.
   */
  void save();

  /**
   * Applies a filter to the current image based on the String selected in the view and uses the
   * integer value when appropriate (only for brighten/darken).
   * @param filter the name of the filter being applied.
   * @param value the value of the filter (for brighten/darken only).
   */
  void apply(String filter, int value);

}
