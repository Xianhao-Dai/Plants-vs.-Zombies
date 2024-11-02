package src.game;

import src.game.util.MainWindowUtil;
import src.game.view.MainEntrancePanel;

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
        MainWindowUtil.mainWindowInsets = frame.getInsets();
        MainEntrancePanel mainEntrancePanel = new MainEntrancePanel();
        frame.add(mainEntrancePanel);
    }
}
