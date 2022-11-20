package view;

public interface ImageProcessingGUIView extends ImageProcessingView {
  /**
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  void refresh();


}
