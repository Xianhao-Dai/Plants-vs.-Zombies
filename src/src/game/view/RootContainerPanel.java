package src.game.view;

import javax.swing.*;
import java.awt.*;

public class RootContainerPanel extends JPanel {
    private final MainEntrancePanel mainEntrancePanel = new MainEntrancePanel(this);
    private final MainMenuPanel mainMenuPanel = new MainMenuPanel(this);
    private final JPanel layoutPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();

    public RootContainerPanel() {
        setLayout(new BorderLayout());
        setVisible(true);
        add(layoutPanel);
        layoutPanel.setLayout(cardLayout);
        layoutPanel.add("mainEntrancePanel", mainEntrancePanel);
        layoutPanel.add("mainMenuPanel", mainMenuPanel);
    }

    public void loadMainEntrancePanel() {
        cardLayout.show(layoutPanel, "mainEntrancePanel");
    }

    public void loadMainMenuPanel() {
        cardLayout.show(layoutPanel, "mainMenuPanel");
    }
}
