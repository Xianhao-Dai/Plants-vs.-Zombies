package src.game.view;

import src.game.util.DialogUtil;
import src.game.util.ImageResourceUtil;
import src.game.util.MainWindowUtil;
import src.game.util.customView.CustomDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenuPanel extends JPanel implements ActionListener {
    private BufferedImage backgroundImageTree;
    private BufferedImage backgroundImageTombstone;
    private BufferedImage backgroundImageLand;
    private BufferedImage backgroundImageSky;
    private BufferedImage backgroundImageCloud_1;
    private BufferedImage backgroundImageCloud_2;
    private BufferedImage backgroundImageCloud_3;
    private BufferedImage backgroundImageCloud_4;
    private BufferedImage backgroundImageCloud_5;
    private BufferedImage backgroundImageCloud_6;
    private BufferedImage backgroundImageTombStoneLine_startAdventure;
    private BufferedImage backgroundImageTombStoneLine_miniGame;
    private BufferedImage backgroundImageTombStoneLine_survival;
    private BufferedImage backgroundImageTombStoneLine_puzzle;
    private BufferedImage backgroundImageWelcomeBack;

    private BufferedImage adventureImage;
    private BufferedImage puzzleImage;
    private BufferedImage miniGameImage;
    private BufferedImage survivalImage;
    private BufferedImage changeNameImage;

    private JButton adventureButton;
    private JButton puzzleButton;
    private JButton miniGameButton;
    private JButton survivalButton;
    private JButton changeNameButton;
    private JLabel nameLabel;

    private final int mainWindowWidth;
    private final int mainWindowHeight;
    private int tombAnchorX;

    private final RootContainerPanel rootContainer;

    MainMenuPanel (RootContainerPanel _rootContainer) {
        mainWindowWidth = MainWindowUtil.mainWindowWidth;
        mainWindowHeight = MainWindowUtil.mainWindowHeight;
        rootContainer = _rootContainer;
        loadCachedImages();
        setUpUI();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImageSky, 0, 0, this);
        g.drawImage(backgroundImageLand, 0, 270, this);
        g.drawImage(backgroundImageCloud_1, 200, 100, this);
        g.drawImage(backgroundImageCloud_2, 300, 175, this);
        g.drawImage(backgroundImageCloud_3, 300, 0, this);
        g.drawImage(backgroundImageCloud_4, 500, 150, this);
        g.drawImage(backgroundImageCloud_5, 600, 200, this);
        g.drawImage(backgroundImageCloud_6, 100, 300, this);
        g.drawImage(backgroundImageTree, 0, 0, this);
        g.drawImage(backgroundImageTombstone, mainWindowWidth - backgroundImageTombstone.getWidth(), 0, this);
        g.drawImage(backgroundImageTombStoneLine_startAdventure, tombAnchorX, 20, this);
        g.drawImage(backgroundImageTombStoneLine_survival, tombAnchorX + 5, 135, this);
        g.drawImage(backgroundImageTombStoneLine_puzzle, tombAnchorX + 10, 220, this);
        g.drawImage(backgroundImageTombStoneLine_miniGame, tombAnchorX + 15, 300, this);
        g.drawImage(backgroundImageWelcomeBack, 50, 0, this);
    }

    private void loadCachedImages() {
        try {
            backgroundImageTree = ImageResourceUtil.loadScaledImage("src/asset/小组件/SelectorScreen_BG_Left.png", 0, mainWindowHeight);
            backgroundImageTombstone = ImageResourceUtil.loadScaledImage("src/asset/小组件/SelectorScreen_BG_Right.png", 0, mainWindowHeight);
            backgroundImageLand = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_BG_Center.png");
            backgroundImageSky = ImageResourceUtil.loadScaledImage("src/asset/小组件/SelectorScreen_BG.jpg", mainWindowWidth, mainWindowHeight);
            backgroundImageCloud_1 = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Cloud1.png");
            backgroundImageCloud_2 = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Cloud2.png");
            backgroundImageCloud_3 = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Cloud3.png");
            backgroundImageCloud_4 = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Cloud4.png");
            backgroundImageCloud_5 = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Cloud5.png");
            backgroundImageCloud_6 = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Cloud6.png");
            backgroundImageTombStoneLine_startAdventure = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Shadow_StartAdventure.png");
            tombAnchorX = mainWindowWidth - backgroundImageTombStoneLine_startAdventure.getWidth() - 70;
            backgroundImageTombStoneLine_survival = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Shadow_Survival.png");
            backgroundImageTombStoneLine_puzzle = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Shadow_Challenge.png");
            backgroundImageTombStoneLine_miniGame = ImageResourceUtil.loadImage("src/asset/小组件/SelectorScreen_Shadow_ZenGarden.png");
            backgroundImageWelcomeBack = ImageResourceUtil.loadImage("src/asset/小组件/welcome_back.png");

            adventureImage = ImageResourceUtil.loadImage("src/asset/小组件/start_adventure.png");
            puzzleImage = ImageResourceUtil.loadImage("src/asset/小组件/puzzle.png");
            miniGameImage = ImageResourceUtil.loadImage("src/asset/小组件/mini_games.png");
            survivalImage = ImageResourceUtil.loadImage("src/asset/小组件/survival.png");
            changeNameImage = ImageResourceUtil.loadImage("src/asset/小组件/change_name.png");
        } catch (IOException _) {
        }
    }

    private void setUpUI() {
        setLayout(null);
        setSize(mainWindowWidth, mainWindowHeight);

        adventureButton = new JButton(new ImageIcon(adventureImage));
        adventureButton.setBounds(tombAnchorX, 20, adventureImage.getWidth(), adventureImage.getHeight());
        adventureButton.setBorderPainted(false);
        adventureButton.setFocusPainted(false);
        adventureButton.setContentAreaFilled(false);
        adventureButton.setVisible(true);
        adventureButton.setActionCommand("adventure");
        adventureButton.addActionListener(this);

        puzzleButton = new JButton(new ImageIcon(puzzleImage));
        puzzleButton.setBounds(tombAnchorX + 10, 220, puzzleImage.getWidth(), puzzleImage.getHeight());
        puzzleButton.setBorderPainted(false);
        puzzleButton.setFocusPainted(false);
        puzzleButton.setContentAreaFilled(false);
        puzzleButton.setVisible(true);
        puzzleButton.setActionCommand("puzzle");
        puzzleButton.addActionListener(this);

        miniGameButton = new JButton(new ImageIcon(miniGameImage));
        miniGameButton.setBounds(tombAnchorX + 5, 135, miniGameImage.getWidth(), miniGameImage.getHeight());
        miniGameButton.setBorderPainted(false);
        miniGameButton.setFocusPainted(false);
        miniGameButton.setContentAreaFilled(false);
        miniGameButton.setVisible(true);
        miniGameButton.setActionCommand("miniGame");
        miniGameButton.addActionListener(this);

        survivalButton = new JButton(new ImageIcon(survivalImage));
        survivalButton.setBounds(tombAnchorX + 15, 300, survivalImage.getWidth(), survivalImage.getHeight());
        survivalButton.setBorderPainted(false);
        survivalButton.setFocusPainted(false);
        survivalButton.setContentAreaFilled(false);
        survivalButton.setVisible(true);
        survivalButton.setActionCommand("miniGame");
        survivalButton.addActionListener(this);

        changeNameButton = new JButton(new ImageIcon(changeNameImage));
        changeNameButton.setBounds(50, 135, changeNameImage.getWidth(), changeNameImage.getHeight());
        changeNameButton.setBorderPainted(false);
        changeNameButton.setFocusPainted(false);
        changeNameButton.setContentAreaFilled(false);
        changeNameButton.setVisible(true);
        changeNameButton.setActionCommand("changeName");
        changeNameButton.addActionListener(this);

        nameLabel = new JLabel();
        nameLabel.setBounds(86, 95, 230, 20);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setVisible(true);

        add(adventureButton);
        add(puzzleButton);
        add(miniGameButton);
        add(survivalButton);
        add(changeNameButton);
        add(nameLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "adventure":
                break;
            case "puzzle":
                break;
            case "miniGame":
                break;
            case "survival":
                break;
            case "changeName":
                JPanel dialog = DialogUtil.showMessage(rootContainer.frame, "", "");
                dialog.setVisible(true);
                break;
            default:
                break;
        }
    }
}
