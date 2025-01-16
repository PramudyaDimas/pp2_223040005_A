package view.main;

import view.jenismember.JenisMemberTableFrame;
import view.member.MemberTableFrame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setTitle("Aplikasi Membership");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JButton jenisMemberButton = new JButton("Jenis Member");
        jenisMemberButton.addActionListener(new MainButtonActionListener(this, "jenis_member"));

        JButton memberButton = new JButton("Member");
        memberButton.addActionListener(new MainButtonActionListener(this, "member"));

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(jenisMemberButton);
        panel.add(memberButton);

        this.add(panel);
    }

    public void openJenisMemberFrame() {
        new JenisMemberTableFrame();
    }

    public void openMemberFrame() {
        new MemberTableFrame();
    }
}