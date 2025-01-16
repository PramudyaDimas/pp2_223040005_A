package view.jenismember;

import java.awt.*;
import javax.swing.*;

public class JenisMemberFrame extends JFrame {
    private final JenisMemberTableFrame jenisMemberTableFrame;
    private final JTextField idTextField;
    private final JTextField namaTextField;
    private final JTextField diskonTextField;

    public JenisMemberFrame(JenisMemberTableFrame jenisMemberTableFrame, int id, String nama, double diskon) {
        this.jenisMemberTableFrame = jenisMemberTableFrame;
        this.setTitle("Jenis Member");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        idTextField = new JTextField(String.valueOf(id));
        idTextField.setEditable(false);
        namaTextField = new JTextField(nama);
        diskonTextField = new JTextField(String.valueOf(diskon));

        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new JenisMemberButtonSimpanActionListener(this));

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idTextField);
        panel.add(new JLabel("Nama:"));
        panel.add(namaTextField);
        panel.add(new JLabel("Diskon:"));
        panel.add(diskonTextField);
        panel.add(new JLabel());
        panel.add(simpanButton);

        this.add(panel);
    }

    public JenisMemberTableFrame getJenisMemberTableFrame() {
        return jenisMemberTableFrame;
    }

    public int getId() {
        return Integer.parseInt(idTextField.getText());
    }

    public String getNama() {
        return namaTextField.getText();
    }

    public double getDiskon() {
        return Double.parseDouble(diskonTextField.getText());
    }
}