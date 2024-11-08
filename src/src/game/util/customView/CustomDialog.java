package src.game.util.customView;

import src.game.util.ImageResourceUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CustomDialog extends JDialog {
    private BufferedImage dialogImage_bottomLeft;
    private BufferedImage dialogImage_bottomRight;
    private BufferedImage dialogImage_topLeft;
    private BufferedImage dialogImage_topRight;
    private BufferedImage dialogImage_bottomMiddle;
    private BufferedImage dialogImage_topMiddle;
    private BufferedImage dialogImage_leftMiddle;
    private BufferedImage dialogImage_rightMiddle;
    private BufferedImage dialogImage_center;
    private BufferedImage dialogImage_header;

    public CustomDialog(JFrame parent, String title, String message) {
        super(parent, true);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setSize(500, 450);
        setLocationRelativeTo(parent);
        int row = 5;
        int column = 5;
        loadCachedImages();
        GridBagLayout g = new GridBagLayout();
        setLayout(g);
        GridBagConstraints c = new GridBagConstraints();

        {
            JLabel l = new JLabel();
            l.setIcon(new ImageIcon(dialogImage_header));
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 5;
            c.gridheight = 1;
            l.setOpaque(false);
            l.setVisible(true);
            this.add(l);
            g.setConstraints(l, c);
        }
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < column;j++) {
                JLabel l = new JLabel();
                if (i == 0) {
                    if (j == 0) {
                        l.setIcon(new ImageIcon(dialogImage_topLeft));
                    } else if (j == column - 1) {
                        l.setIcon(new ImageIcon(dialogImage_topRight));
                    } else {
                        l.setIcon(new ImageIcon(dialogImage_topMiddle));
                    }
                } else if (i == row - 1) {
                    if (j == 0) {
                        l.setIcon(new ImageIcon(dialogImage_bottomLeft));
                    } else if (j == column - 1) {
                        l.setIcon(new ImageIcon(dialogImage_bottomRight));
                    } else {
                        l.setIcon(new ImageIcon(dialogImage_bottomMiddle));
                    }
                } else {
                    if (j == 0) {
                        l.setIcon(new ImageIcon(dialogImage_leftMiddle));
                    } else if (j == column - 1) {
                        l.setIcon(new ImageIcon(dialogImage_rightMiddle));
                    } else {
                        l.setIcon(new ImageIcon(dialogImage_center));
                    }
                }
                c.gridx = j;
                c.gridy = i + 1;
                c.gridwidth = 1;
                c.gridheight = 1;
                c.fill = GridBagConstraints.BOTH;
                c.insets = new Insets(0, 0, 0, 0);
                g.setConstraints(l, c);
                l.setOpaque(false);
                l.setVisible(true);
                add(l);
            }
        }
    }

    private void loadCachedImages() {
        try {
            dialogImage_bottomLeft = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_bottomleft.png");
            dialogImage_bottomRight = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_bottomright.png");
            dialogImage_topLeft = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_topleft.png");
            dialogImage_topRight = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_topright.png");
            dialogImage_bottomMiddle = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_bottommiddle.png");
            dialogImage_topMiddle = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_topmiddle.png");
            dialogImage_leftMiddle = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_centerleft.png");
            dialogImage_rightMiddle = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_centerright.png");
            dialogImage_center = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_centermiddle.png");
            dialogImage_header = ImageResourceUtil.loadImage("src/asset/小组件/Dialog/dialog_header.png");
        } catch (IOException _) {
        }
    }
}
