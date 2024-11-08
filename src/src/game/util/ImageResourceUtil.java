package src.game.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResourceUtil {
    /**
     * Load origin image
     * @param path image relative path
     * @return origin image
     * @throws IOException exception
     */
    public static BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    /**
     * Proportionally stretch image icon until its width or height equivalent to that of the main window
     * @param path image relative path
     * @return stretched full-window image
     * @throws IOException exception
     */
    public static BufferedImage loadFullWindowImage(String path) throws IOException {
        int width = MainWindowUtil.mainWindowWidth - MainWindowUtil.mainWindowInsets.left - MainWindowUtil.mainWindowInsets.right;
        int height = MainWindowUtil.mainWindowHeight - MainWindowUtil.mainWindowInsets.top - MainWindowUtil.mainWindowInsets.bottom;
        return ImageResourceUtil.loadScaledImage(path, width, height);
    }

    /**
     * Proportionally stretch image icon with a certain scale
     * @param path image relative path
     * @param scale resized scale
     * @return stretched image with certain scale
     * @throws IOException exception
     */
    public static BufferedImage loadScaledImage(String path, float scale) throws IOException {
        BufferedImage image = loadImage(path);
        return ImageResourceUtil.loadScaledImage(path, (int) (image.getWidth() * scale), (int) (image.getWidth() * scale));
    }

    /**
     * Proportionally stretch image icon until its width or height equivalent to that of the parameter
     * @param path image relative path
     * @param width target width
     * @param height target height
     * @return stretched image
     * @throws IOException exception
     */
    public static BufferedImage loadScaledImage(String path, int width, int height) throws IOException {
        BufferedImage image = loadImage(path);
        float stretchScaleOnWidth = width / (float)image.getWidth();
        float stretchScaleOnHeight = height / (float)image.getHeight();
        float stretchScale = Math.max(stretchScaleOnHeight, stretchScaleOnWidth);
        if (Float.compare(stretchScale, stretchScaleOnHeight) == 0) {
            width = (int)(image.getWidth() * stretchScale);
        } else if (Float.compare(stretchScale, stretchScaleOnWidth) == 0) {
            height = (int)(image.getHeight() * stretchScale);
        }
        return ImageResourceUtil.resizeImage(image, width, height);
    }

    /**
     * Proportionally stretch image icon until its width or height equivalent to that of the parameter
     * @param originImage original image
     * @param width target width
     * @param height target height
     * @return stretched image
     */
    public static BufferedImage resizeImage(BufferedImage originImage, int width, int height) {
        Image image = originImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        scaledImage.getGraphics().drawImage(image, 0, 0, null);
        return scaledImage;
    }

    /**
     * Rotate image icon with a certain angle
     * @param path image relative path
     * @param angle target angle
     * @return rotated image
     * @throws IOException exception
     */
    public static BufferedImage loadRotatedImage(String path, int angle) throws IOException {
        BufferedImage image = loadImage(path);
        return ImageResourceUtil.rotateImage(image, angle);
    }

    /**
     * Rotate image icon with a certain angle
     * @param originImage original image
     * @param angle target angle
     * @return rotated image
     */
    public static BufferedImage rotateImage(BufferedImage originImage, int angle) {
        int width = originImage.getWidth();
        int height = originImage.getHeight();
        BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedImage.createGraphics();
        AffineTransform transform = new AffineTransform();
        transform.rotate((double) angle / 360, (double) width / 2, (double) height / 2);
        g2d.drawImage(originImage, transform, null);
        g2d.dispose();
        return rotatedImage;
    }
}
