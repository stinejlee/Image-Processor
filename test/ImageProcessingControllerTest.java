import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.StringReader;

import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.ImageUtil;
import model.Image;
import model.Pixel;
import model.SaveType;
import view.ImageProcessingTextView;
import view.ImageProcessingView;

/**
 * Tests for {@link ImageProcessingController}.
 */
public class ImageProcessingControllerTest {

  @Test
  public void loadFilterSaveBigImageTest() {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("-load res/big.ppm big\n" +
            "-red-component big redBig\n" +
            "-save res/redBig.ppm redBig");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
  }
  // Tests the processImages method on a valid load command
  @Test
  public void processImagesLoadTest() {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("-load res/testing.ppm test");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Image image = ImageUtil.readPPM("res/testing.ppm");
    Assert.assertEquals(image.toString(), model.getImage("test").toString());
  }

  // Tests the processImages method on a valid save command
  @Test
  public void processImagesSaveTest() {
    Image image = ImageUtil.readPPM("res/newTesting.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-save res/newTesting.ppm test");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertEquals(image.toString(), model.getImage("test").toString());
  }

  // Tests the processImages method on a valid redGreyScale command
  @Test
  public void processImagesRedGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-red-component test redTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("redTest").toString());
  }

  // Tests the processImages method on a valid greenGreyScale command
  @Test
  public void processImagesGreenGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-green-component test greenTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("greenTest").toString());
  }

  // Tests the processImages method on a valid blueGreyScale command
  @Test
  public void processImagesBlueGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-blue-component test blueTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("blueTest").toString());
  }

  // Tests the processImages method on a valid valueGreyScale command
  @Test
  public void processImagesValueGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-value-component test valueTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("valueTest").toString());
  }

  // Tests the processImages method on a valid intensityGreyScale command
  @Test
  public void processImagesIntensityGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-intensity-component test intensityTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("intensityTest").toString());
  }

  // Tests the processImages method on a valid lumaGreyScale command
  @Test
  public void processImagesLumaGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-luma-component test lumaTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("lumaTest").toString());
  }

  // Tests the processImages method on a valid horizontalFlip command
  @Test
  public void processImagesHorizontalFlipTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-horizontal-flip test horizontalTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("horizontalTest").toString());
  }

  // Tests the processImages method on a valid verticalFlip command
  @Test
  public void processImagesVerticalFlipTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-vertical-flip test verticalTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(), model.getImage("verticalTest").toString());
  }

  // Tests the processImages method on a valid brighten command
  @Test
  public void processImagesBrightenTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-brighten 10 test brightenTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(),
            model.getImage("brightenTest").toString());
  }

  @Test
  public void processImagesGaussianBlurTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-blur test blurTest");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
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
    Assert.assertEquals(expectedImage.toString(),
            model.getImage("blurTest").toString());
  }

  // Tests the loadImage method on a ppm file with inputs
  @Test
  public void loadImagePPMTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("-load res/testing.ppm test");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertEquals(image.toString(), model.getImage("test").toString());
  }

  // Tests the loadImage method on a png file with inputs
  @Test
  public void loadImagePNGTest() {
    Image image = ImageUtil.readConventional("res/testing.png");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("-load res/testing.png test");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertEquals(image.toString(), model.getImage("test").toString());
  }

  // Tests the loadImage method
  @Test
  public void loadImageTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Readable input = new StringReader("");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.loadImage("res/testing.ppm", "test", SaveType.ppm);
    Assert.assertEquals(image.toString(), model.getImage("test").toString());
  }

  // Tests the save method on a ppm file
  @Test
  public void savePPMTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-save res/newtesting.ppm test");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/newtesting.ppm").isFile());

    model.addImage("test2", image);
    input = new StringReader("-save res/testing2.ppm test");
    controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/testing2.ppm").isFile());
  }

  // Tests the save method on a png file & overriding imageName
  @Test
  public void savePNGTest() {
    Image image = ImageUtil.readConventional("res/big.png");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("test", image);
    Readable input = new StringReader("-save res/newbig.png test");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/newbig.png").isFile());

    image = ImageUtil.readPPM("res/testing.ppm");
    model.addImage("test", image);
    input = new StringReader("-save res/testing.png test");
    controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/testing.png").isFile());
  }

  // Tests the save method on a jpg file
  @Test
  public void saveJPGTest() {
    Image image = ImageUtil.readConventional("res/big.jpg");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("big", image);
    Readable input = new StringReader("-save res/newbig.jpg big");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/newbig.jpg").isFile());


    image = ImageUtil.readConventional("res/big.bmp");
    model.addImage("big2", image);
    input = new StringReader("-save res/newbig2.jpg big2");
    controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/newbig2.jpg").isFile());
  }

  // Tests the save method on a bmp file
  @Test
  public void saveBMPTest() {
    Image image = ImageUtil.readConventional("res/big.bmp");
    ImageProcessingModel model = new ImageProcessingModelImpl();
    model.addImage("big", image);
    Readable input = new StringReader("-save res/newbig.bmp big");
    ImageProcessingView view = new ImageProcessingTextView(model);
    ImageProcessingController controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/newbig.bmp").isFile());

    image = ImageUtil.readConventional("res/big.jpg");
    model.addImage("big", image);
    input = new StringReader("-save res/big.bmp big");
    controller = new ImageProcessingControllerImpl(model, view, input);
    controller.processImages();
    Assert.assertTrue(new File("res/big.bmp").isFile());
  }

}
