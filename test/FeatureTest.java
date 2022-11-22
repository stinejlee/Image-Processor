import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Feature;
import controller.FeatureImpl;
import controller.filters.GaussianBlurFilter;
import controller.filters.SepiaFilter;
import model.Image;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.ImageUtil;
import view.ImageProcessingGUIView;
import view.ImageProcessingGUIViewImpl;

/**
 * Tests for {@link Feature}
 * and
 * for {@link FeatureImpl}.
 */
public class FeatureTest {
  ImageProcessingModel model;
  ImageProcessingGUIView view;

  Feature feature;
  ImageProcessingModel mockModel;
  MockGUIView mockView;
  FeatureImpl mock;
  Image image;
  Image mockSavedImage;


  // Tests constructing a Feature with a Null model
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidModelTest() {
    model = null;
    view = new ImageProcessingGUIViewImpl();
    feature = new FeatureImpl(model, view);
  }

  // Tests constructing a Feature with a Null view
  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalidViewTest() {
    ImageProcessingModel model = new ImageProcessingModelImpl();
    ImageProcessingGUIView view = null;
    Feature feature = new FeatureImpl(model, view);
  }

  @Before
  public void initData() {
    model = new ImageProcessingModelImpl();
    view = new ImageProcessingGUIViewImpl();
    feature = new FeatureImpl(model, view);
    model.addImage("test", ImageUtil.readPPM("res/Koala.ppm"));

    mockModel = new ImageProcessingModelImpl();
    mockView = new MockGUIView();
    mock = new FeatureImpl(mockModel, mockView);

    image = ImageUtil.readPPM("res/Koala.ppm");
  }

  // Tests the load method
  @Test
  public void loadTest() {
    mock.load();
    Assert.assertEquals(mockModel.getImage("test").toString(), image.toString());

    Assert.assertTrue(mockView.actionRun("image set"));
    Assert.assertTrue(mockView.actionRun("reset histograms"));
    Assert.assertTrue(mockView.actionRun("reset image"));

  }

  // Tests the save method
  @Test
  public void saveTest() {
    mockModel.addImage("test", ImageUtil.readPPM("res/Koala.ppm"));
    mock.save();
    mockSavedImage = ImageUtil.readPPM("res/newKoala.ppm");
    Assert.assertEquals(image.toString(), mockSavedImage.toString());
  }

  // Tests the apply method mutates the image given a blur filter
  @Test
  public void applyBlurTest() {
    Assert.assertNotEquals(model.getImage("test").toString(),
            image.applyFilter(new GaussianBlurFilter("test", "test")).toString());
    feature.apply("Blur", 0);
    Assert.assertEquals(model.getImage("test").toString(),
            image.applyFilter(new GaussianBlurFilter("test", "test")).toString());
  }

  // Tests the apply method mutates the image given a brighten filter
  @Test
  public void applyBrightenTest() {
    Assert.assertNotEquals(model.getImage("test").toString(),
            image.brighten(255).toString());
    feature.apply("Brighten", 255);
    Assert.assertEquals(model.getImage("test").toString(),
            image.brighten(255).toString());
  }

  // Tests the apply method accordingly updates the image
  @Test
  public void applyTest() {
    mockModel.addImage("test", ImageUtil.readPPM("res/Koala.ppm"));
    Assert.assertNotEquals(mockModel.getImage("test").toString(),
            image.applyColorFilter(new SepiaFilter("test", "test")).toString());
    mock.apply("Sepia", 0);
    Assert.assertEquals(mockModel.getImage("test").toString(),
            image.applyColorFilter(new SepiaFilter("test", "test")).toString());

    Assert.assertTrue(mockView.actionRun("image set"));
    Assert.assertTrue(mockView.actionRun("reset histograms"));
    Assert.assertTrue(mockView.actionRun("reset image"));
  }
}
