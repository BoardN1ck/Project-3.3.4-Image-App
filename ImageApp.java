/*
  ImageApp: 
 */
import java.awt.Color;

public class ImageApp
{
  public static void main(String[] args)
  {

    // use any file from the lib folder
    String pictureFile = "lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();
    for (int row = 0; row < recoloredPixels.length; row++) {
      for (int col = 0; col < recoloredPixels[0].length; col++) {
        Pixel p = recoloredPixels[row][col];
        p.setRed(p.getRed() / 2);
        p.setBlue(p.getBlue() + 50);
      }
    }
    recoloredImg.show();

    /* to be implemented */

    // Image #2 Using the original image and pixels, create a photographic negative of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();
    for (Pixel[] rowArray : negPixels) {
      for (Pixel p : rowArray) {
        p.setRed(255 - p.getRed());
        p.setGreen(255 - p.getGreen());
        p.setBlue(255 - p.getBlue());
      }
    }
    negImg.show();

    // Image #3 Using the original image and pixels, create a grayscale version of the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();
    for (Pixel[] rowArray : grayscalePixels) {
      for (Pixel p : rowArray) {
        int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
        p.setRed(avg);
        p.setGreen(avg);
        p.setBlue(avg);
      }
    }
    grayscaleImg.show();

    /* to be implemented */

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] srcPixels4 = new Picture(pictureFile).getPixels2D();
    Pixel[][] targetPixels4 = upsidedownImage.getPixels2D();
    int rows = srcPixels4.length;
    int cols = srcPixels4[0].length;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        targetPixels4[r][c].setColor(srcPixels4[rows - 1 - r][cols - 1 - c].getColor());
      }
    }
    upsidedownImage.show();

    // Image #5: Rotate 90 degrees
    Picture orig5 = new Picture(pictureFile);
    Picture rotateImg = new Picture(orig5.getHeight(), orig5.getWidth()); 
    Pixel[][] src5 = orig5.getPixels2D();
    Pixel[][] dest5 = rotateImg.getPixels2D();

    for (int r = 0; r < src5.length; r++) {
        for (int c = 0; c < src5[0].length; c++) {
            int newRow = c;
            int newCol = src5.length - 1 - r;
            if (newRow < dest5.length && newCol < dest5[0].length) {
                dest5[newRow][newCol].setColor(src5[r][c].getColor());
            }
        }
    }
    rotateImg.show();

    // Image #6: Rotate -90 degrees
    Picture orig6 = new Picture(pictureFile);
    Picture rotateImg2 = new Picture(orig6.getHeight(), orig6.getWidth());
    Pixel[][] src6 = orig6.getPixels2D();
    Pixel[][] dest6 = rotateImg2.getPixels2D();

    for (int r = 0; r < src6.length; r++) {
        for (int c = 0; c < src6[0].length; c++) {
            int newRow = src6[0].length - 1 - c;
            int newCol = r;
            if (newRow < dest6.length && newCol < dest6[0].length) {
                dest6[newRow][newCol].setColor(src6[r][c].getColor());
            }
        }
    }
    rotateImg2.show();

    // final image
    /* * Pseudocode:
         * 1. Load the large background image (lib1) and the small foreground image (lib2).
         * 2. Get 2D pixel arrays for both.
         * 3. Define a starting (row, col) position on the large image.
         * 4. Loop through every pixel of the small image.
         * 5. For each pixel, check if it is "white" (RGB values all very high).
         * 6. If it is NOT white, copy its color to the corresponding pixel in the large image.
         * 7. Show the result.
         */

        String smallFile = "lib2/bird.png";
        Picture background = new Picture(pictureFile);
        Picture foreground = new Picture(smallFile);

        System.out.println("Background Width: " + background.getWidth());
        System.out.println("Bird Width: " + foreground.getWidth());

        Pixel[][] bgPixels = background.getPixels2D();
        Pixel[][] fgPixels = foreground.getPixels2D();

        int startRow = 100;
        int startCol = 100;

        for (int r = 0; r < fgPixels.length; r++) { 
            for (int c = 0; c < fgPixels[0].length; c++) {
              Pixel fgPix = fgPixels[r][c];
            
              if (fgPix.getRed() < 230 || fgPix.getGreen() < 230 || fgPix.getBlue() < 230) {
                if (startRow + r < bgPixels.length && startCol + c < bgPixels[0].length) {
                    bgPixels[startRow + r][startCol + c].setColor(fgPix.getColor());
                }
            }
        } 
    }


background.show();
System.out.println("Final image should be visible now!");


    // for testing  2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];


  }
}
