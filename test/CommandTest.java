import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;

import controller.IOCommand;
import controller.ImageProcessingCommand;
import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import controller.imagecommands.Brighten;
import controller.imagecommands.HorizontalFlip;
import controller.iocommands.Load;
import controller.iocommands.Save;
import controller.imagecommands.ValueGreyscale;
import controller.imagecommands.VerticalFlip;
import controller.filters.BlueGreyscaleFilter;
import controller.filters.GaussianBlurFilter;
import controller.filters.GreenGreyscaleFilter;
import controller.filters.IntensityGreyscaleFilter;
import controller.filters.LumaGreyscaleFilter;
import controller.filters.RedGreyscaleFilter;
import controller.filters.SepiaFilter;
import controller.filters.SharpenFilter;
import model.Image;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.ImageUtil;
import model.Pixel;
import model.SaveType;
import view.ImageProcessingTextView;
import view.ImageProcessingView;

/**
 * Test class for all commands,
 * extends ACommandTest that has a helper function to help abstract test.
 */
public class CommandTest extends ACommandTest {

  // Test for constructing a redGreyScale object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testRedGreyScaleConstructorThrowsExceptionForNullImageName() {
    new RedGreyscaleFilter(null, "hello");
  }

  // Test for constructing a redGreyScale object with a null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testRedGreyScaleConstructorThrowsExceptionForNullDestName() {
    new RedGreyscaleFilter("hello", null);
  }

  // Tests execute method on a redGreyScale object
  @Test
  public void testRedGreyscaleExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand redGS = new RedGreyscaleFilter("test", "testRedGS");
    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(255, 255, 255);
    pixels[0][1] = new Pixel(0, 0, 0);
    pixels[0][2] = new Pixel(0, 0, 0);
    pixels[1][0] = new Pixel(100, 100, 100);
    pixels[1][1] = new Pixel(0, 0, 0);
    pixels[1][2] = new Pixel(0, 0, 0);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(redGS, expectedImage, "testRedGS", model));
  }

  // Test for constructing a greenGreyScale object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testGreenGreyScaleConstructorThrowsExceptionForNullImageName() {
    new GreenGreyscaleFilter(null, "hello");
  }

  // Test for constructing a greenGreyScale object with a
  // null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testGreenGreyScaleConstructorThrowsExceptionForNullDestName() {
    new GreenGreyscaleFilter("hello", null);
  }

  // Tests execute method on a greenGreyScale object
  @Test
  public void testGreenGreyscaleExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand greenGS = new GreenGreyscaleFilter("test", "testGreenGS");
    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(0, 0, 0);
    pixels[0][1] = new Pixel(255, 255, 255);
    pixels[0][2] = new Pixel(0, 0, 0);
    pixels[1][0] = new Pixel(0, 0, 0);
    pixels[1][1] = new Pixel(100, 100, 100);
    pixels[1][2] = new Pixel(0, 0, 0);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(greenGS, expectedImage, "testGreenGS", model));
  }

  // Test for constructing a blueGreyScale object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testBlueGreyScaleConstructorThrowsExceptionForNullImageName() {
    new RedGreyscaleFilter(null, "hello");
  }

  // Test for constructing a blueGreyScale object with a
  // null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testBlueGreyScaleConstructorThrowsExceptionForNullDestName() {
    new RedGreyscaleFilter("hello", null);
  }

  // Tests execute method on a blueGreyScale object
  @Test
  public void testBlueGreyscaleExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand blueGS = new BlueGreyscaleFilter("test", "testBlueGS");
    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(0, 0, 0);
    pixels[0][1] = new Pixel(0, 0, 0);
    pixels[0][2] = new Pixel(255, 255, 255);
    pixels[1][0] = new Pixel(0, 0, 0);
    pixels[1][1] = new Pixel(0, 0, 0);
    pixels[1][2] = new Pixel(100, 100, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(blueGS, expectedImage, "testBlueGS", model));
  }

  // Test for constructing a valueGreyScale object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testValueGreyScaleConstructorThrowsExceptionForNullImageName() {
    new ValueGreyscale(null, "hello");
  }

  // Test for constructing a valueGreyScale object with a
  // null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testValueGreyScaleConstructorThrowsExceptionForNullDestName() {
    new ValueGreyscale("hello", null);
  }

  // Tests execute method on a valueGreyScale object
  @Test
  public void testValueGreyscaleExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand valueGS = new ValueGreyscale("test", "testValueGS");
    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(255, 255, 255);
    pixels[0][1] = new Pixel(255, 255, 255);
    pixels[0][2] = new Pixel(255, 255, 255);
    pixels[1][0] = new Pixel(100, 100, 100);
    pixels[1][1] = new Pixel(100, 100, 100);
    pixels[1][2] = new Pixel(100, 100, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(valueGS, expectedImage, "testValueGS", model));
  }

  // Test for constructing a intensityGreyScale object
  // with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testIntensityGreyScaleConstructorThrowsExceptionForNullImageName() {
    new IntensityGreyscaleFilter(null, "hello");
  }

  // Test for constructing a intensityGreyScale object with a
  // null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testIntensityGreyScaleConstructorThrowsExceptionForNullDestName() {
    new IntensityGreyscaleFilter("hello", null);
  }

  // Tests execute method on a intensityGreyScale object
  @Test
  public void testIntensityGreyscaleExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand intensityGS = new IntensityGreyscaleFilter("test", "testIntensityGS");
    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(85, 85, 85);
    pixels[0][1] = new Pixel(85, 85, 85);
    pixels[0][2] = new Pixel(85, 85, 85);
    pixels[1][0] = new Pixel(33, 33, 33);
    pixels[1][1] = new Pixel(33, 33, 33);
    pixels[1][2] = new Pixel(33, 33, 33);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(intensityGS, expectedImage, "testIntensityGS", model));
  }

  // Test for constructing a lumaGreyScale object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testLumaGreyScaleConstructorThrowsExceptionForNullImageName() {
    new LumaGreyscaleFilter(null, "hello");
  }

  // Test for constructing a lumaGreyScale object with a
  // null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testLumaGreyScaleConstructorThrowsExceptionForNullDestName() {
    new LumaGreyscaleFilter("hello", null);
  }

  // Tests execute method on a lumaGreyScale object
  @Test
  public void testLumaGreyscaleExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand lumaGS = new LumaGreyscaleFilter("test", "testLumaGS");
    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(54, 54, 54);
    pixels[0][1] = new Pixel(182, 182, 182);
    pixels[0][2] = new Pixel(18, 18, 18);
    pixels[1][0] = new Pixel(21, 21, 21);
    pixels[1][1] = new Pixel(72, 72, 72);
    pixels[1][2] = new Pixel(7, 7, 7);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(lumaGS, expectedImage, "testLumaGS", model));
  }

  // Test for constructing a horizontalFlip object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testHorizontalFlipConstructorThrowsExceptionForNullimageName() {
    new HorizontalFlip(null, "hello");
  }

  // Test for constructing a horizontalFlip object
  // with a null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testHorizontalFlipConstructorThrowsExceptionForNullDestImageName() {
    new HorizontalFlip("hello", null);
  }

  // Tests execute method on a horizontalFlip object
  @Test
  public void testHorizontalFlipExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand horizontalFlip = new HorizontalFlip("test", "horizontalTest");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(0, 0, 255);
    pixels[0][1] = new Pixel(0, 255, 0);
    pixels[0][2] = new Pixel(255, 0, 0);
    pixels[1][0] = new Pixel(0, 0, 100);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(100, 0, 0);
    pixels[2][0] = new Pixel(0, 0, 0);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(255, 255, 255);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(horizontalFlip, expectedImage, "horizontalTest", model));
  }

  // Test for constructing a verticalFlip object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testVerticalFlipConstructorThrowsExceptionForNullimageName() {
    new VerticalFlip(null, "hello");
  }

  // Test for constructing a verticalFlip object with a null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testVerticalFlipConstructorThrowsExceptionForNullDestImageName() {
    new VerticalFlip("hello", null);
  }

  // Tests execute method on a verticalFlip object
  @Test
  public void testVerticalFlipExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand verticalFlip = new VerticalFlip("test", "verticalTest");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(255, 255, 255);
    pixels[0][1] = new Pixel(100, 100, 100);
    pixels[0][2] = new Pixel(0, 0, 0);
    pixels[1][0] = new Pixel(100, 0, 0);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(0, 0, 100);
    pixels[2][0] = new Pixel(255, 0, 0);
    pixels[2][1] = new Pixel(0, 255, 0);
    pixels[2][2] = new Pixel(0, 0, 255);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(verticalFlip, expectedImage, "verticalTest", model));
  }

  // Test for constructing a brighten object with a null parameter in the increment position
  @Test(expected = IllegalArgumentException.class)
  public void testBrightenConstructorThrowsExceptionForNullIncrement() {
    new Brighten(null, "hello", "hello");
  }

  // Test for constructing a brighten object with a non-integer string in the increment position
  @Test(expected = IllegalArgumentException.class)
  public void testBrightenConstructorThrowsExceptionForStringIncrement() {
    new Brighten("a", "hello", "hello");
  }

  // Test for constructing a brighten object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testBrightenConstructorThrowsExceptionForNullImageName() {
    new Brighten("hello", null, "hello");
  }

  // Test for constructing a brighten object with a null parameter in the destImageName position
  @Test(expected = IllegalArgumentException.class)
  public void testBrightenConstructorThrowsExceptionForNullDestImageName() {
    new Brighten("hello", "hello", null);
  }

  // Tests execute method on a brighten object
  @Test
  public void testBrightenExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand brighten =
            new Brighten("10", "test", "brightenTest");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(255, 10, 10);
    pixels[0][1] = new Pixel(10, 255, 10);
    pixels[0][2] = new Pixel(10, 10, 255);
    pixels[1][0] = new Pixel(110, 10, 10);
    pixels[1][1] = new Pixel(10, 110, 10);
    pixels[1][2] = new Pixel(10, 10, 110);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(110, 110, 110);
    pixels[2][2] = new Pixel(10, 10, 10);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(brighten, expectedImage, "brightenTest", model));
  }

  @Test
  public void testGaussianBlurExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand blur =
            new GaussianBlurFilter("test", "brightenTest");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(76, 38, 0);
    pixels[0][1] = new Pixel(38, 76, 38);
    pixels[0][2] = new Pixel(0, 38, 76);
    pixels[1][0] = new Pixel(95, 67, 38);
    pixels[1][1] = new Pixel(57, 85, 57);
    pixels[1][2] = new Pixel(6, 35, 63);
    pixels[2][0] = new Pixel(89, 83, 76);
    pixels[2][1] = new Pixel(63, 69, 63);
    pixels[2][2] = new Pixel(13, 19, 25);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(blur, expectedImage, "brightenTest", model));
  }

  @Test
  public void testSharpenExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand sharpen =
            new SharpenFilter("test", "sharpenTest");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(236, 44, 0);
    pixels[0][1] = new Pixel(44, 236, 44);
    pixels[0][2] = new Pixel(0, 44, 236);
    pixels[1][0] = new Pixel(253, 178, 44);
    pixels[1][1] = new Pixel(178, 253, 178);
    pixels[1][2] = new Pixel(0, 82, 157);
    pixels[2][0] = new Pixel(255, 255, 236);
    pixels[2][1] = new Pixel(157, 157, 157);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(sharpen, expectedImage, "sharpenTest", model));
  }

  @Test
  public void testSepiaExecute() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    ImageProcessingCommand sepia =
            new SepiaFilter("test", "sepiaTest");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(100, 89, 69);
    pixels[0][1] = new Pixel(196, 175, 136);
    pixels[0][2] = new Pixel(48, 43, 33);
    pixels[1][0] = new Pixel(39, 35, 27);
    pixels[1][1] = new Pixel(77, 69, 53);
    pixels[1][2] = new Pixel(19, 17, 13);
    pixels[2][0] = new Pixel(255, 255, 239);
    pixels[2][1] = new Pixel(135, 120, 94);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(sepia, expectedImage, "sepiaTest", model));
  }

  // Test for constructing a Load object with a null parameter in the imagePath position
  @Test(expected = IllegalArgumentException.class)
  public void testLoadConstructorThrowsExceptionForNullImagePath() {
    new Load(null, "hello");
  }

  // Test for constructing a Load object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testLoadConstructorThrowsExceptionForNullImageName() {
    new Load("hello", null);
  }

  // Tests execute method on a Load object
  @Test
  public void testLoadExecute() {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    IOCommand load =
            new Load("res/testing.ppm", "test");

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(255, 0, 0);
    pixels[0][1] = new Pixel(0, 255, 0);
    pixels[0][2] = new Pixel(0, 0, 255);
    pixels[1][0] = new Pixel(100, 0, 0);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(0, 0, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(load, expectedImage, "test", model, controller));
  }

  // Test for constructing a Save object with a null parameter in the imagePath position
  @Test(expected = IllegalArgumentException.class)
  public void testSaveConstructorThrowsExceptionForNullImagePath() {
    new Save(null, "hello");
  }

  // Test for constructing a Save object with a null parameter in the imageName position
  @Test(expected = IllegalArgumentException.class)
  public void testSaveConstructorThrowsExceptionForNullImageName() {
    new Save("hello", null);
  }

  // Tests execute method on a Save object
  @Test
  public void testSaveExecute() {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.loadImage("res/testing.ppm", "test", SaveType.ppm);
    IOCommand save = new Save("res/testing.bmp", "test");
    controller.loadImage("res/testing.bmp", "newTest", SaveType.bmp);

    Pixel[][] pixels = new Pixel[3][3];
    pixels[0][0] = new Pixel(255, 0, 0);
    pixels[0][1] = new Pixel(0, 255, 0);
    pixels[0][2] = new Pixel(0, 0, 255);
    pixels[1][0] = new Pixel(100, 0, 0);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(0, 0, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image expectedImage = new Image(pixels);

    Assert.assertEquals(true,
            testExecuteHelper(save, expectedImage, "newTest", model, controller));
  }
}
