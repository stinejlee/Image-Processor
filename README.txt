This image processing program was created by Anthony Chen and Christine Lee. The purpose of this
program is to give the user the ability to load images, apply filters or actions, and save
the resulting image.

The program can be used in three ways:

- To use this program with a text file with all the scripts, type this in terminal:
java -jar res/ImageProgram.jar -file [filepath]

- To use this program in an interactive text mode that takes command scripts and executes
them one at a time, type:
java -jar res/ImageProgram.jar -text

- To use the image processor GUI where the image can be viewed as it is edited, type:
java -jar res/ImageProgram.jar

When using a script file or the interactive text mode, the following commands can be used:
-load [image-path] [image-name]
-save [image-path] [image-name]
-(red-component, green-component, blue-component, value-component, intensity-component, luma-component) [image-name] [dest-image-name]
-(horizontal-flip, vertical-flip) [image-name] [dest-image-name]
-brighten [increment] [image-name] [dest-image-name]
-blur [image-name] [dest-image-name]
-sharpen [image-name] [dest-image-name]
-sepia [image-name] [dest-image-name]

To use the GUI interface, click load to load an image to edit. A file chooser will prompt the
user to select an image. To apply a filter or action, select an option from the dropdown, and click
the apply button below the dropdown. If you would like to brighten or darken, select a number
in the number spinner next to where it says "Brighten by:" and click the Apply button that is
right next to it. Positive values will brighten, negative values will darken. To save the current
image, click Save and it will prompt the user to name the file and choose a filepath to save
the image to.

While the image is being edited, histograms will display the levels of Red, Green, Blue, and
Intensity values present in the image. These will change whenever the color in the image are
altered.

For this assignment, we created a few new interface and classes to work with the GUI.

- The Feature interface acts as a controller for the GUI view and our original model.
    - This is implemented by the FeatureImpl class, which takes in a model and a GUI view and
      manages the interactions between them.
    - These were added because the old controller would not work with our new GUI.
- The ImageProcessingGUIView interface represents the GUI view of the image processing program, and
  it extends the ImageProcessingView interface.
    - This is implemented by the ImageProcessingGUIViewImpl class, which uses Java Swing to display
      an interactive GUI that displays an image and all the features of the image processor.
      - There are a couple Panel classes, such as ImagePanel and Histogram Panel, that are added to
        the main display. These panels are made in separate classes because these will change in
        appearance whenever a change is made to the image.

No changes were made to the model.

# We created and own the images used in this project.
# We are authorizing the usage of those images in this project.