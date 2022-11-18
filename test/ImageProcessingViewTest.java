import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import model.Image;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageProcessingTextView;
import view.ImageProcessingView;

/**
 * Test class for the ImageProcessingTextView class.
 */
public class ImageProcessingViewTest {

  @Test(expected = IllegalArgumentException.class)
  public void testTextViewConstructorThrowsExceptionForNullModel() {
    new ImageProcessingTextView(null, new StringBuilder());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTextViewConstructorThrowsExceptionForNullAppendable() {
    Map<String, Image> map = new HashMap<>();
    new ImageProcessingTextView(new ImageProcessingModelImpl(map), null);
  }

  // Unfinished testing
  @Test
  public void testTextViewConstructorOutputsForInvalidCommand() {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    Appendable text = new StringBuilder("");
    ImageProcessingView view = new ImageProcessingTextView(model, text);
    Assert.assertEquals(true, true);
  }
}
