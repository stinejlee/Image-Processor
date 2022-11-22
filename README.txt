Our design uses a ImageProcessingCommand interface, ImageProcessingController interface, and ImageProcessingModel interface.
The ImageProcessingCommand interface is implemented by a class for each command.
Each command class takes in varying inputs to perform its different functions to images.
The ImageProcessingController interface is implemented by a class that represents the controller.
The ImageProcessingControllerImpl class contains all operations which allows the processor to react to inputs.
The ImageProcessingModel interface is implemented by a class that represents the model.
The ImageProcessingModelImpl class contains all operations that allows changes to the model to be made.
The Image class is a separate class which represents an Image and contains pixels and dimensions.
The Pixel class is a separate class which represents a pixel with rgb color components valued between 0 and 255.
The ImageUtil class is a utility class which contains utility methods for reading and writing PPM images to and from files.

For this assignment we added a ImageProcessingView interface in order to test the output when invalid commands are used.
The ImageProcessingView interface is implemented by ImageProcessingTextView that represents the view of the program.
However, we were unable to complete writing tests for the view.

We also created an IFilter interface that represents an Image filter for the class.
This interface is implemented by AFilter, which is extended by AColorFilter. These two abstract
classes represents an Image Filter and a Color Transformation filter. Color transformations function
differently from regular image filters, which is shown in the execute method.

We also made a change to the ImageProcessingCommand interface. We added an overarching interface, ICommand,
that is implemented by ImageProcessingCommand and IOCommand. IOCommand represents commands that deal with
loading and saving images. We converted all of our Greyscale Commands into GreayScale filters except for value greyscale.

In order for our model to work with the Filters, we added two methods, applyFilter and applyColorFilter.
ApplyFilter works for non-color transformation filters and applyColorFilter works with color transformations.

** Note: there is still a bug in our applyColorFilter method that is causing NullPointerExceptions in larger images.
Our written tests passed because they use smaller images. We will patch this for the next assignment.

We also added the ability to load and save different image formats. Our program now supports JPG, PNG, and BMP images.
JPG and BMP images tend to experience some pixel loss.

# We created and own the images used in this project.
# We are authorizing the usage of those images in this project.