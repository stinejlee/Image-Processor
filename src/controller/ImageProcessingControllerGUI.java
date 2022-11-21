package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ImageProcessingModel;
import model.SaveType;
import view.ImageProcessingGUIView;
import view.ImageProcessingView;

public class ImageProcessingControllerGUI implements ImageProcessingController, ActionListener {
  private final Feature feature;
  public ImageProcessingControllerGUI(Feature feature) throws IllegalArgumentException {
    if (feature == null) {
      throw new IllegalArgumentException("Null parameter given.");
    }
    this.feature = feature;
  }

  @Override
  public void processImages() throws IllegalStateException {

  }

  @Override
  public void save(String fileName, String imageName, SaveType sType) {

  }

  @Override
  public void loadImage(String fileName, String imageName, SaveType sType) {

  }

  @Override
  public void actionPerformed(ActionEvent e) {
//    case "Open file": {
//      final JFileChooser fchooser = new JFileChooser(".");
//      FileNameExtensionFilter filter = new FileNameExtensionFilter(
//              "JPG & GIF Images", "jpg", "gif");
//      fchooser.setFileFilter(filter);
//      int retvalue = fchooser.showOpenDialog(SwingFeaturesFrame.this);
//      if (retvalue == JFileChooser.APPROVE_OPTION) {
//        File f = fchooser.getSelectedFile();
//        fileOpenDisplay.setText(f.getAbsolutePath());
//      }
//    }
//    break;
//    case "Save file": {
//      final JFileChooser fchooser = new JFileChooser(".");
//      int retvalue = fchooser.showSaveDialog(SwingFeaturesFrame.this);
//      if (retvalue == JFileChooser.APPROVE_OPTION) {
//        File f = fchooser.getSelectedFile();
//        fileSaveDisplay.setText(f.getAbsolutePath());
//      }
//    }
//    break;
  }
}
