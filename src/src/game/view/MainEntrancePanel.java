package src.game.view;

import src.game.util.ImageResourceUtil;
import src.game.util.MainWindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainEntrancePanel extends JPanel {
    private final JLabel grassLabel;
    private final JLabel grassRollLabel;
    private final int grassRollOriginXPos;
    private int grassRollXPos;
    private int grassRollAngle;
    private final Timer timer;

    public MainEntrancePanel() {
        // use absolute layout on entrance button
        setLayout(null);
        int mainWindowWidth = MainWindowUtil.mainWindowWidth;
        int mainWindowHeight = MainWindowUtil.mainWindowHeight;
        JButton entranceButton = new JButton();
        grassLabel = new JLabel();
        timer = new Timer(0, _ -> updateRollAnimation(mainWindowWidth / 3));
        // adjustment of icon and button
        int leftOffset = 5;
        int bottomOffset = 23;
        grassRollLabel = new JLabel();
        grassRollOriginXPos = mainWindowWidth / 3 - 9 * leftOffset;
        grassRollAngle = 0;
        grassRollXPos = grassRollOriginXPos;
        try {
            BufferedImage grassImage = ImageResourceUtil.loadScaledImage("src/asset/小组件/LoadBar_grass.png", mainWindowWidth / 3, 0);
            grassLabel.setIcon(new ImageIcon(grassImage));
            grassLabel.setBounds(mainWindowWidth / 3 - leftOffset, mainWindowHeight * 3 / 4 - bottomOffset, grassImage.getWidth(), grassImage.getHeight());

            BufferedImage buttonImage = ImageResourceUtil.loadScaledImage("src/asset/小组件/LoadBar_dirt.png", mainWindowWidth / 3, mainWindowHeight / 12);
            entranceButton.setIcon(new ImageIcon(buttonImage));
            entranceButton.setBounds(mainWindowWidth / 3, mainWindowHeight * 3 / 4, buttonImage.getWidth(), buttonImage.getHeight());
            entranceButton.setBorderPainted(false);
            entranceButton.setFocusPainted(false);
            entranceButton.setContentAreaFilled(false);
            entranceButton.setVisible(true);

            ImageIcon grassRollOriginImage = new ImageIcon("src/asset/小组件/关卡/SodRollCap.png");
            BufferedImage grassRollImage = ImageResourceUtil.loadScaledImage("src/asset/小组件/关卡/SodRollCap.png", grassRollOriginImage.getIconWidth(), grassRollOriginImage.getIconHeight());
            grassRollLabel.setIcon(new ImageIcon(grassRollImage));
            grassRollLabel.setBounds(mainWindowWidth / 3 - leftOffset, mainWindowHeight * 3 / 4 - 65, grassRollOriginImage.getIconWidth(), grassRollOriginImage.getIconHeight());

            add(grassRollLabel);
            add(grassLabel);
            add(entranceButton);
            timer.start();
        } catch (IOException _) {}
    }

    private void updateRollAnimation(int width) {
        grassRollXPos += 3;
        grassRollAngle += 20;
        if (grassRollXPos > grassRollOriginXPos + width) {
            timer.stop();
            return;
        }

        try {
            BufferedImage rotatedGrassImage = ImageResourceUtil.loadRotatedImage("src/asset/小组件/关卡/SodRollCap.png", grassRollAngle);
            grassRollLabel.setIcon(new ImageIcon(rotatedGrassImage));
            grassLabel.setBounds(grassLabel.getX(), grassLabel.getY(), grassRollXPos - grassRollOriginXPos, grassLabel.getHeight());
            grassRollLabel.setLocation(grassRollXPos, grassRollLabel.getY());
            repaint(grassRollLabel.getBounds());
            repaint(grassLabel.getBounds());
        } catch (IOException _) {}
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage titleScreen = ImageResourceUtil.loadScaledImage("src/asset/小组件/关卡/titlescreen.jpg");
            g.drawImage(titleScreen, 0, 0, this);
        } catch (Exception _) {
        }
    }
}
