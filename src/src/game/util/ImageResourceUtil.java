package src.game.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResourceUtil {
    public static BufferedImage loadScaledImage(String path) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        /*
        Proportionally stretch image icon until its width or height equivalent to that of the main window
        */
        int newHeight = MainWindowUtil.mainWindowHeight - MainWindowUtil.mainWindowInsets.top - MainWindowUtil.mainWindowInsets.bottom;
        int newWidth = MainWindowUtil.mainWindowWidth - MainWindowUtil.mainWindowInsets.left - MainWindowUtil.mainWindowInsets.right;
        float stretchScaleOnHeight = newHeight / (float)image.getHeight();
        float stretchScaleOnWidth = newWidth / (float)image.getWidth();
        float stretchScale = Math.max(stretchScaleOnHeight, stretchScaleOnWidth);
        if (Float.compare(stretchScale, stretchScaleOnHeight) == 0) {
            newWidth = (int)(image.getWidth() * stretchScale);
        } else if (Float.compare(stretchScale, stretchScaleOnWidth) == 0) {
            newHeight = (int)(image.getHeight() * stretchScale);
        }
        return ImageResourceUtil.resizeImage(image, newWidth, newHeight);
    }

    private static BufferedImage resizeImage(BufferedImage originImage, int newWidth, int newHeight) {
        Image image = originImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        scaledImage.getGraphics().drawImage(image, 0, 0, null);
        return scaledImage;
    }
}
