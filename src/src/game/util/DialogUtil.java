package src.game.util;

import src.game.util.customView.CustomDialog;

import javax.swing.*;

public class DialogUtil {
    public static JPanel showMessage(JFrame frame, String title, String message) {
        JPanel container = new JPanel();
        container.setLayout(null);
        JLabel titleLabel = new JLabel(title);
        JLabel messageLabel = new JLabel(message);
        CustomDialog customDialog = new CustomDialog(frame, title, message);

        container.add(titleLabel);
        container.add(messageLabel);
        container.add(customDialog);
        return container;
    }
}
