package view;

import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionListener;

import controller.Feature;

public interface ImageProcessingGUIView extends ImageProcessingView {
  void setFeature(Feature feature);
}
