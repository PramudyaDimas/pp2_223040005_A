package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainButtonActionListener implements ActionListener {
    private final MainFrame mainFrame;
    private final String buttonType;

    public MainButtonActionListener(MainFrame mainFrame, String buttonType) {
        this.mainFrame = mainFrame;
        this.buttonType = buttonType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonType.equals("jenis_member")) {
            mainFrame.openJenisMemberFrame();
        } else if (buttonType.equals("member")) {
            mainFrame.openMemberFrame();
        }
    }
}