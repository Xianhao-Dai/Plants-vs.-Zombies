package src.game;

import src.game.util.MainWindowUtil;
import src.game.view.RootContainerPanel;

import javax.swing.*;

public class MainEntrance {
    public static void run() {
        MainWindowUtil.mainWindowWidth = 1000;
        MainWindowUtil.mainWindowHeight = 600;
        JFrame frame = new JFrame("Plants Vs. Zombies");
        frame.setSize(MainWindowUtil.mainWindowWidth, MainWindowUtil.mainWindowHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindowUtil.mainWindowInsets = frame.getInsets();
        RootContainerPanel rootContainerPanel = new RootContainerPanel();
        frame.setContentPane(rootContainerPanel);
        rootContainerPanel.loadMainEntrancePanel();
    }
}
