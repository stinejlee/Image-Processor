package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * This class contains utility methods to read and write a PPM image from and to files.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and create an image of
   * the colors.
   *
   * @param fileName filename the path of the file.
   * @return the Image that is read.
   * @throws IllegalArgumentException if file is not found or file is invalid.
   */
  public static Image readPPM(String fileName) throws IllegalArgumentException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File " + fileName + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    Pixel[][] pixels = new Pixel[height][width];
    int maxValue = sc.nextInt();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels[i][j] = new Pixel(r, g, b);
      }
    }
    return new Image(pixels);
  }


  /**
   * Writes an image file in the PPM format.
   *
   * @param fileName the file path that the Image will be saved under.
   * @param image    the image that is being written as a PPM file.
   * @throws IllegalArgumentException if file is unable to be written.
   */
  public static void writePPM(String fileName, Image image) throws IllegalArgumentException {
    File file = new File(fileName);
    FileOutputStream writer = null;
    StringBuilder builder = new StringBuilder();

    try {
      file.createNewFile();
    } catch (IOException e) {
      throw new IllegalArgumentException("File failed to be created");
    }

    builder.append("P3 \n");
    builder.append("# Created by Ant & Christine \n");
    builder.append(image.width + " " + image.height + "\n");
    builder.append("255 \n");
    for (int i = 0; i < image.height; i++) {
      for (int j = 0; j < image.width; j++) {
        builder.append(image.getPixelAt(i, j).getRed() + "\n");
        builder.append(image.getPixelAt(i, j).getGreen() + "\n");
        builder.append(image.getPixelAt(i, j).getBlue() + "\n");
      }
    }

    try {
      writer = new FileOutputStream(file);
      byte[] bytes = builder.toString().getBytes();
      writer.write(bytes);
    } catch (IOException e) {
      throw new IllegalArgumentException("File unable to be written");
    }
  }

  /**
   *   Read an image file in an conventional format and create an image of
   *   the colors.
   *
   * @param fileName  filename the path of the file.
   * @return          the Image that is read.
   * @throws IllegalArgumentException if file is unable to be written.
   */
  public static Image readConventional(String fileName) throws IllegalArgumentException {

    BufferedImage image;
    try {
      image = ImageIO.read(new FileInputStream(fileName));
    } catch (IOException e) {
      throw new IllegalArgumentException("File " + fileName + " not found!");
    }

    int width = image.getWidth();
    int height = image.getHeight();
    Pixel[][] pixels = new Pixel[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Color color = new Color(image.getRGB(j,i));
        pixels[i][j] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
      }
    }
    return new Image(pixels);
  }

  /**
   * Writes an image file in a conventional file format (jpg, bmp, png).
   *
   * @param fileName  the file path that the Image will be saved under.
   * @param image     the image that is being written as a conventional file.
   * @param fileType  the type of file that is being written
   * @throws IllegalArgumentException if file is unable to be written.
   */
  public static void writeConventional(String fileName, Image image, String fileType)
          throws IllegalArgumentException {
    File file = new File(fileName);
    BufferedImage pic = new BufferedImage(image.width, image.height, TYPE_INT_RGB);

    for (int i = 0; i < image.height; i++) {
      for (int j = 0; j < image.width; j++) {
        int r = image.getPixelAt(i, j).getRed();
        int g = image.getPixelAt(i, j).getGreen();
        int b = image.getPixelAt(i, j).getBlue();
        Color color = new Color(r,g,b);
        pic.setRGB(j,i, color.getRGB());
      }
    }

    try {
      ImageIO.write(pic, fileType, file);
    } catch (IOException e) {
      throw new IllegalArgumentException("File unable to be written");
    }
  }
}