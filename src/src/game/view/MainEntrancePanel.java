package src.game.view;

import src.game.util.ImageResourceUtil;
import src.game.util.MainWindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainEntrancePanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            BufferedImage titleScreen = ImageResourceUtil.loadScaledImage("src/asset/小组件/关卡/titlescreen.jpg");
            g.drawImage(titleScreen, 0, 0, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
