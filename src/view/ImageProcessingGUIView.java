package view;

import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionListener;

public interface ImageProcessingGUIView extends ImageProcessingView {
  /**
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  void refresh();

  /**
   * Transmit an error message to the view, in case
   * the command could not be processed correctly
   *
   * @param error
   */
  void showErrorMessage(String error);

  /**
   * Provide the view with an action listener for
   * the button that should cause the program to
   * process a command. This is so that when the button
   * is pressed, control goes to the action listener
   *
   * @param actionEvent
   */
  void setCommandButtonListener(ActionListener actionEvent);

  void setListSelectionListener(ListSelectionListener actionEvent);
}
