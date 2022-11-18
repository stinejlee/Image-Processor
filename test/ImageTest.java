import org.junit.Assert;
import org.junit.Test;

import controller.filters.BlueGreyscaleFilter;
import controller.filters.GaussianBlurFilter;
import controller.filters.GreenGreyscaleFilter;
import controller.filters.IntensityGreyscaleFilter;
import controller.filters.LumaGreyscaleFilter;
import controller.filters.RedGreyscaleFilter;
import controller.filters.SepiaFilter;
import controller.filters.SharpenFilter;
import model.Image;
import model.ImageUtil;
import model.Pixel;

/**
 * Tests for {@link Image}.
 */
public class ImageTest {
  Pixel[][] pixels = new Pixel[3][3];

  // Tests the toString 
  @Test
  public void toStringTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    Assert.assertEquals("255, 0, 0|0, 255, 0|0, 0, 255|\n" +
            "100, 0, 0|0, 100, 0|0, 0, 100|\n" +
            "255, 255, 255|100, 100, 100|0, 0, 0|\n", image.toString());
  }

  // Tests constructing an image with a null array of pixels
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidTest() {
    Image image = new Image(null);
  }

  // Tests redGreyScale filter
  @Test
  public void redGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(255, 255, 255);
    pixels[0][1] = new Pixel(0, 0, 0);
    pixels[0][2] = new Pixel(0, 0, 0);
    pixels[1][0] = new Pixel(100, 100, 100);
    pixels[1][1] = new Pixel(0, 0, 0);
    pixels[1][2] = new Pixel(0, 0, 0);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    image = image.applyColorFilter(new RedGreyscaleFilter("hello", "there"));
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests greenGreyScale method
  @Test
  public void greenGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(0, 0, 0);
    pixels[0][1] = new Pixel(255, 255, 255);
    pixels[0][2] = new Pixel(0, 0, 0);
    pixels[1][0] = new Pixel(0, 0, 0);
    pixels[1][1] = new Pixel(100, 100, 100);
    pixels[1][2] = new Pixel(0, 0, 0);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    image = image.applyColorFilter(new GreenGreyscaleFilter("hello", "there"));
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests blueGreyScale method
  @Test
  public void blueGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(0, 0, 0);
    pixels[0][1] = new Pixel(0, 0, 0);
    pixels[0][2] = new Pixel(255, 255, 255);
    pixels[1][0] = new Pixel(0, 0, 0);
    pixels[1][1] = new Pixel(0, 0, 0);
    pixels[1][2] = new Pixel(100, 100, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    image = image.applyColorFilter(new BlueGreyscaleFilter("hello", "there"));
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests valueGreyScale method
  @Test
  public void valueGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(255, 255, 255);
    pixels[0][1] = new Pixel(255, 255, 255);
    pixels[0][2] = new Pixel(255, 255, 255);
    pixels[1][0] = new Pixel(100, 100, 100);
    pixels[1][1] = new Pixel(100, 100, 100);
    pixels[1][2] = new Pixel(100, 100, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    image = image.greyScale(Image.GreyscaleType.Value);
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests intensityGreyScale method
  @Test
  public void intensityGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(85, 85, 85);
    pixels[0][1] = new Pixel(85, 85, 85);
    pixels[0][2] = new Pixel(85, 85, 85);
    pixels[1][0] = new Pixel(33, 33, 33);
    pixels[1][1] = new Pixel(33, 33, 33);
    pixels[1][2] = new Pixel(33, 33, 33);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    image = image.applyColorFilter(new IntensityGreyscaleFilter("hello", "there"));
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests lumaGreyScale method
  @Test
  public void lumaGreyScaleTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(54, 54, 54);
    pixels[0][1] = new Pixel(182, 182, 182);
    pixels[0][2] = new Pixel(18, 18, 18);
    pixels[1][0] = new Pixel(21, 21, 21);
    pixels[1][1] = new Pixel(72, 72, 72);
    pixels[1][2] = new Pixel(7, 7, 7);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    image = image.applyColorFilter(new LumaGreyscaleFilter("hello", "there"));
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests horizontalFlip method
  @Test
  public void horizontalFlipTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(0, 0, 255);
    pixels[0][1] = new Pixel(0, 255, 0);
    pixels[0][2] = new Pixel(255, 0, 0);
    pixels[1][0] = new Pixel(0, 0, 100);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(100, 0, 0);
    pixels[2][0] = new Pixel(0, 0, 0);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(255, 255, 255);
    image = image.flip(Image.FlipType.Horizontal);
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests VerticalFlip method
  @Test
  public void verticalFlipTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(255, 255, 255);
    pixels[0][1] = new Pixel(100, 100, 100);
    pixels[0][2] = new Pixel(0, 0, 0);
    pixels[1][0] = new Pixel(100, 0, 0);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(0, 0, 100);
    pixels[2][0] = new Pixel(255, 0, 0);
    pixels[2][1] = new Pixel(0, 255, 0);
    pixels[2][2] = new Pixel(0, 0, 255);
    image = image.flip(Image.FlipType.Vertical);
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests brighten method when incrementing by a positive number
  @Test
  public void brightenAddTest() {
    Pixel[][] pixels2 = new Pixel[3][3];
    pixels[0][0] = new Pixel(50, 50, 50);
    pixels[0][1] = new Pixel(50, 50, 50);
    pixels[0][2] = new Pixel(50, 50, 50);
    pixels[1][0] = new Pixel(50, 50, 50);
    pixels[1][1] = new Pixel(50, 50, 50);
    pixels[1][2] = new Pixel(50, 50, 50);
    pixels[2][0] = new Pixel(50, 50, 50);
    pixels[2][1] = new Pixel(50, 50, 50);
    pixels[2][2] = new Pixel(50, 50, 50);
    Image image = new Image(pixels);
    pixels2[0][0] = new Pixel(60, 60, 60);
    pixels2[0][1] = new Pixel(60, 60, 60);
    pixels2[0][2] = new Pixel(60, 60, 60);
    pixels2[1][0] = new Pixel(60, 60, 60);
    pixels2[1][1] = new Pixel(60, 60, 60);
    pixels2[1][2] = new Pixel(60, 60, 60);
    pixels2[2][0] = new Pixel(60, 60, 60);
    pixels2[2][1] = new Pixel(60, 60, 60);
    pixels2[2][2] = new Pixel(60, 60, 60);
    Image result = new Image(pixels2);
    image = image.brighten(10);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests brighten method when incrementing by a negative number
  @Test
  public void brightenSubTest() {
    Pixel[][] pixels2 = new Pixel[3][3];
    pixels[0][0] = new Pixel(50, 50, 50);
    pixels[0][1] = new Pixel(50, 50, 50);
    pixels[0][2] = new Pixel(50, 50, 50);
    pixels[1][0] = new Pixel(50, 50, 50);
    pixels[1][1] = new Pixel(50, 50, 50);
    pixels[1][2] = new Pixel(50, 50, 50);
    pixels[2][0] = new Pixel(50, 50, 50);
    pixels[2][1] = new Pixel(50, 50, 50);
    pixels[2][2] = new Pixel(50, 50, 50);
    Image image = new Image(pixels);
    pixels2[0][0] = new Pixel(40, 40, 40);
    pixels2[0][1] = new Pixel(40, 40, 40);
    pixels2[0][2] = new Pixel(40, 40, 40);
    pixels2[1][0] = new Pixel(40, 40, 40);
    pixels2[1][1] = new Pixel(40, 40, 40);
    pixels2[1][2] = new Pixel(40, 40, 40);
    pixels2[2][0] = new Pixel(40, 40, 40);
    pixels2[2][1] = new Pixel(40, 40, 40);
    pixels2[2][2] = new Pixel(40, 40, 40);
    Image result = new Image(pixels2);
    image = image.brighten(-10);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests brighten method when incrementing by a positive number that values cap at 255
  @Test
  public void testBrightenDoesNotExceed255() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(255, 10, 10);
    pixels[0][1] = new Pixel(10, 255, 10);
    pixels[0][2] = new Pixel(10, 10, 255);
    pixels[1][0] = new Pixel(110, 10, 10);
    pixels[1][1] = new Pixel(10, 110, 10);
    pixels[1][2] = new Pixel(10, 10, 110);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(110, 110, 110);
    pixels[2][2] = new Pixel(10, 10, 10);
    Image result = new Image(pixels);
    image = image.brighten(10);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests brighten method when incrementing by a negative number that values cap at 0
  @Test
  public void brightenDoesNotGoBelow0() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(245, 0, 0);
    pixels[0][1] = new Pixel(0, 245, 0);
    pixels[0][2] = new Pixel(0, 0, 245);
    pixels[1][0] = new Pixel(90, 0, 0);
    pixels[1][1] = new Pixel(0, 90, 0);
    pixels[1][2] = new Pixel(0, 0, 90);
    pixels[2][0] = new Pixel(245, 245, 245);
    pixels[2][1] = new Pixel(90, 90, 90);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image result = new Image(pixels);
    image = image.brighten(-10);
    Assert.assertEquals(result.toString(), image.toString());
  }

  @Test
  public void blurTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(76, 38, 0);
    pixels[0][1] = new Pixel(38, 76, 38);
    pixels[0][2] = new Pixel(0, 38, 76);
    pixels[1][0] = new Pixel(95, 67, 38);
    pixels[1][1] = new Pixel(57, 85, 57);
    pixels[1][2] = new Pixel(6, 35, 63);
    pixels[2][0] = new Pixel(89, 83, 76);
    pixels[2][1] = new Pixel(63, 69, 63);
    pixels[2][2] = new Pixel(13, 19, 25);
    Image result = new Image(pixels);
    image = image.applyFilter(new GaussianBlurFilter("hello", "there"));
    Assert.assertEquals(result.toString(), image.toString());
  }

  @Test
  public void sharpenTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(236, 44, 0);
    pixels[0][1] = new Pixel(44, 236, 44);
    pixels[0][2] = new Pixel(0, 44, 236);
    pixels[1][0] = new Pixel(253, 178, 44);
    pixels[1][1] = new Pixel(178, 253, 178);
    pixels[1][2] = new Pixel(0, 82, 157);
    pixels[2][0] = new Pixel(255, 255, 236);
    pixels[2][1] = new Pixel(157, 157, 157);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image result = new Image(pixels);
    image = image.applyFilter(new SharpenFilter("hello", "there"));
    Assert.assertEquals(result.toString(), image.toString());
  }

  @Test
  public void sepiaTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(100, 89, 69);
    pixels[0][1] = new Pixel(196, 175, 136);
    pixels[0][2] = new Pixel(48, 43, 33);
    pixels[1][0] = new Pixel(39, 35, 27);
    pixels[1][1] = new Pixel(77, 69, 53);
    pixels[1][2] = new Pixel(19, 17, 13);
    pixels[2][0] = new Pixel(255, 255, 239);
    pixels[2][1] = new Pixel(135, 120, 94);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image result = new Image(pixels);
    image = image.applyColorFilter(new SepiaFilter("hello", "there"));
    Assert.assertEquals(result.toString(), image.toString());
  }
}
