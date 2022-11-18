import org.junit.Assert;
import org.junit.Test;

import model.Image;
import model.ImageUtil;
import model.Pixel;

/**
 * Tests for {@link ImageUtil}.
 */
public class ImageUtilTest {
  Pixel[][] pixels = new Pixel[3][3];

  // Tests readPPM method
  @Test
  public void readPPMTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    pixels[0][0] = new Pixel(255, 0, 0);
    pixels[0][1] = new Pixel(0, 255, 0);
    pixels[0][2] = new Pixel(0, 0, 255);
    pixels[1][0] = new Pixel(100, 0, 0);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(0, 0, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests readPPM method where it is attempted to read a ppm that does not exist
  @Test(expected = IllegalArgumentException.class)
  public void readPPMInvalidPPMTest() {
    Image image = ImageUtil.readPPM("res/NotFound.ppm");
  }

  // Tests readPPM method where it is attempted to read a ppm that does not have P3 as its token
  @Test(expected = IllegalArgumentException.class)
  public void readPPMInvalidTextTest() {
    Image image = ImageUtil.readPPM("res/NoP3.ppm");
  }

  // Tests writePPM method
  @Test
  public void writePPMTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageUtil.writePPM("res/newtesting.ppm", image);
    Image result = ImageUtil.readPPM("res/newtesting.ppm");
    Assert.assertEquals(image.toString(), result.toString());
  }

  // Tests readConventional method where it is attempted to read a ppm that does not exist
  @Test(expected = IllegalArgumentException.class)
  public void readConventionalInvalidTest() {
    Image image = ImageUtil.readConventional("res/NotFound.ppm");
  }

  // Tests readConventional method
  @Test
  public void readConventionalTest() {
    Image image = ImageUtil.readConventional("res/testing.png");
    pixels[0][0] = new Pixel(255, 0, 0);
    pixels[0][1] = new Pixel(0, 255, 0);
    pixels[0][2] = new Pixel(0, 0, 255);
    pixels[1][0] = new Pixel(100, 0, 0);
    pixels[1][1] = new Pixel(0, 100, 0);
    pixels[1][2] = new Pixel(0, 0, 100);
    pixels[2][0] = new Pixel(255, 255, 255);
    pixels[2][1] = new Pixel(100, 100, 100);
    pixels[2][2] = new Pixel(0, 0, 0);
    Image result = new Image(pixels);
    Assert.assertEquals(result.toString(), image.toString());
  }

  // Tests readConventional method
  @Test
  public void writeConventionalTest() {
    Image image = ImageUtil.readPPM("res/testing.ppm");
    ImageUtil.writeConventional("res/testing.png", image, "png");
    Image result = ImageUtil.readConventional("res/testing.png");
    Assert.assertEquals(image.toString(), result.toString());
  }

}
