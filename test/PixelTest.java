import org.junit.Assert;
import org.junit.Test;

import model.Pixel;

/**
 * Tests for {@link Pixel}.
 */
public class PixelTest {

  // Tests constructing a pixel with a negative value in r color value position
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidNegRTest() {
    Pixel p = new Pixel(-1, 0, 0);
  }

  // Tests constructing a pixel with a negative value in g color value position
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidNegGTest() {
    Pixel p = new Pixel(0, -1, 0);
  }

  // Tests constructing a pixel with a negative value in b color value position
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidNegBTest() {
    Pixel p = new Pixel(0, 0, -1);
  }

  // Tests constructing a pixel with a value over 255 in r color value position
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidAboveRTest() {
    Pixel p = new Pixel(1000, 0, 0);
  }

  // Tests constructing a pixel with a value over 255 in g color value position
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidAboveGTest() {
    Pixel p = new Pixel(0, 1000, 0);
  }

  // Tests constructing a pixel with a value over 255 in b color value position
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidAboveBTest() {
    Pixel p = new Pixel(0, 0, 1000);
  }

  // Tests the getRed method
  @Test
  public void getRedTest() {
    Pixel p = new Pixel(1, 2, 3);
    Assert.assertEquals(1, p.getRed());
  }

  // Tests the getGreen method
  @Test
  public void getGreenTest() {
    Pixel p = new Pixel(1, 2, 3);
    Assert.assertEquals(2, p.getGreen());
  }

  // Tests the getBlue method
  @Test
  public void getBlueTest() {
    Pixel p = new Pixel(1, 2, 3);
    Assert.assertEquals(3, p.getBlue());
  }

  // Tests the getValue method
  @Test
  public void getValueTest() {
    Pixel p = new Pixel(1, 2, 3);
    Assert.assertEquals(3, p.getValue());
  }

  // Tests the getIntensity method
  @Test
  public void getIntensityTest() {
    Pixel p = new Pixel(1, 2, 3);
    Assert.assertEquals(2, p.getIntensity());
  }

  // Tests the getLuma method
  @Test
  public void getLumaTest() {
    Pixel p = new Pixel(1, 2, 3);
    Assert.assertEquals(2, p.getLuma());
  }
}
