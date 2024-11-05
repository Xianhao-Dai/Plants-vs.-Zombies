package src.game.view;

import src.game.util.ImageResourceUtil;
import src.game.util.MainWindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainEntrancePanel extends JPanel {
    private  BufferedImage dirtImage;
    private  BufferedImage grassImage;
    private  BufferedImage grassRollImage;
    private BufferedImage backgroundImage;
    private JButton dirtButton;
    private JLabel grassLabel;
    private JLabel grassRollLabel;

    private final int mainWindowWidth;
    private final int mainWindowHeight;

    private int grassRollOriginXPos;
    private int grassRollXPos;
    private int grassRollAngle;
    private double grassRollScale;
    private final Timer timer;

    public MainEntrancePanel() {
        mainWindowWidth = MainWindowUtil.mainWindowWidth;
        mainWindowHeight = MainWindowUtil.mainWindowHeight;
        loadCachedImages();
        setUpUI();
        timer = new Timer(10, _ -> updateRollAnimation(mainWindowWidth / 3));
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    private void loadCachedImages() {
        try {
            dirtImage = ImageResourceUtil.loadFullWindowImage("src/asset/小组件/LoadBar_dirt.png", mainWindowWidth / 3, mainWindowHeight / 12);
            grassImage = ImageResourceUtil.loadFullWindowImage("src/asset/小组件/LoadBar_grass.png", mainWindowWidth / 3, 0);
            grassRollImage = ImageResourceUtil.loadImage("src/asset/小组件/关卡/SodRollCap.png");
            backgroundImage = ImageResourceUtil.loadFullWindowImage("src/asset/小组件/关卡/titlescreen.jpg");
        } catch (IOException _) {
        }
    }

    private void setUpUI() {
        setLayout(null);

        dirtButton = new JButton(new ImageIcon(dirtImage));
        dirtButton.setForeground(Color.BLACK);
        dirtButton.setFont(new Font("Chalkduster", Font.BOLD, 25));
        dirtButton.setHorizontalTextPosition(SwingConstants.CENTER);
        dirtButton.setBounds(mainWindowWidth / 3, mainWindowHeight * 3 / 4, dirtImage.getWidth(), dirtImage.getHeight());
        dirtButton.setBorderPainted(false);
        dirtButton.setFocusPainted(false);
        dirtButton.setContentAreaFilled(false);
        dirtButton.setDisabledIcon(new ImageIcon(dirtImage));
        dirtButton.setEnabled(false);
        dirtButton.setVisible(true);

        int horizontalOffset = 5;
        int verticalOffset_1 = 20;
        int verticalOffset_2 = 40;

        grassLabel = new JLabel(new ImageIcon(grassImage));
        grassLabel.setHorizontalAlignment(SwingConstants.LEFT);
        grassLabel.setBounds(mainWindowWidth / 3 - horizontalOffset, mainWindowHeight * 3 / 4 - verticalOffset_1, grassImage.getWidth(), grassImage.getHeight());

        grassRollLabel = new JLabel(new ImageIcon(grassRollImage));
        grassRollLabel.setBounds(mainWindowWidth / 3 - horizontalOffset, mainWindowHeight * 3 / 4 - verticalOffset_1 - verticalOffset_2, grassRollImage.getWidth(), grassRollImage.getHeight());
        grassRollOriginXPos = mainWindowWidth / 3 - grassRollImage.getWidth() / 2;
        grassRollXPos = grassRollOriginXPos;
        grassRollAngle = 0;
        grassRollScale = 1.0;

        add(grassRollLabel);
        add(grassLabel);
        add(dirtButton);
    }


    private void updateRollAnimation(int width) {
        grassRollXPos += 3;
        grassRollAngle += 20;
        grassRollScale -= 0.0055;
        if (grassRollXPos > grassRollOriginXPos + width) {
            grassRollLabel.setVisible(false);
            dirtButton.setText("GAME START");
            dirtButton.setEnabled(true);
            timer.stop();
            return;
        }
        grassLabel.setBounds(grassLabel.getX(), grassLabel.getY(), grassRollXPos - grassRollOriginXPos, grassLabel.getHeight());
        repaint(grassLabel.getBounds());

        int grassRowNewWidth = (int) (grassRollImage.getWidth() * grassRollScale);
        int grassRowNewHeight = (int) (grassRollImage.getHeight() * grassRollScale);
        BufferedImage rotatedGrassImage = ImageResourceUtil.resizeImage(ImageResourceUtil.rotateImage(grassRollImage, grassRollAngle), grassRowNewWidth, grassRowNewHeight);
        grassRollLabel.setIcon(new ImageIcon(rotatedGrassImage));
        grassRollLabel.setBounds(grassRollXPos + grassRollLabel.getWidth() - grassRowNewWidth, grassRollLabel.getY() + grassRollLabel.getHeight() - grassRowNewHeight, grassRowNewWidth, grassRowNewHeight);
        repaint(grassRollLabel.getBounds());
    }
}
