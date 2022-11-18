package controller;

/**
 * Represents a filter that can be applied to an image.
 */
public interface IFilter extends ImageProcessingCommand {

  void initValues();
  
  int getWidth();

  int getHeight();

  double getValueAt(int row, int col);

}
