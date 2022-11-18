import org.junit.Assert;
import org.junit.Test;

import model.Image;
import model.ImageUtil;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Tests for {@link ImageProcessingModel}.
 */
public class ImageProcessingModelTest {
  ImageProcessingModel model = new ImageProcessingModelImpl();
  Image image = ImageUtil.readPPM("res/testing.ppm");

  // Tests the addImage method
  @Test
  public void addImageTest() {
    model.addImage("test", image);
    Assert.assertEquals(image.toString(), model.getImage("test").toString());
  }

  // Tests the getImage method
  @Test
  public void getImageTest() {
    model.addImage("test", image);
    Image image2 = model.getImage("test");
    Assert.assertEquals(image2.toString(), image.toString());
  }

  // Tests the getImage method where the user is trying to get an image
  // that does not exist in the model
  @Test(expected = IllegalArgumentException.class)
  public void getImageInvalidTest() {
    model.getImage("doesntExist");
  }

}
