package view.member;

import dao.JenisMemberDao;
import model.JenisMember;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MemberFrame extends JFrame {
    private final MemberTableFrame memberTableFrame;
    private final JTextField idTextField;
    private final JTextField namaTextField;
    private final JTextField alamatTextField;
    private final JComboBox<JenisMember> jenisMemberComboBox;
    private final JenisMemberDao jenisMemberDao = new JenisMemberDao();

    public MemberFrame(MemberTableFrame memberTableFrame, int id, String nama, String alamat, int jenisMemberId) {
        this.memberTableFrame = memberTableFrame;
        this.setTitle("Member");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        idTextField = new JTextField(String.valueOf(id));
        idTextField.setEditable(false);
        namaTextField = new JTextField(nama);
        alamatTextField = new JTextField(alamat);

        List<JenisMember> jenisMemberList = jenisMemberDao.selectAll();
        jenisMemberComboBox = new JComboBox<>(jenisMemberList.toArray(new JenisMember[0]));
        if (jenisMemberId != 0) {
            JenisMember selectedJenisMember = jenisMemberDao.selectById(jenisMemberId);
            jenisMemberComboBox.setSelectedItem(selectedJenisMember);
        }

        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new MemberButtonSimpanActionListener(this));

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idTextField);
        panel.add(new JLabel("Nama:"));
        panel.add(namaTextField);
        panel.add(new JLabel("Alamat:"));
        panel.add(alamatTextField);
        panel.add(new JLabel("Jenis Member:"));
        panel.add(jenisMemberComboBox);
        panel.add(new JLabel());
        panel.add(simpanButton);

        this.add(panel);
    }

    public MemberTableFrame getMemberTableFrame() {
        return memberTableFrame;
    }

    public int getId() {
        return Integer.parseInt(idTextField.getText());
    }

    public String getNama() {
        return namaTextField.getText();
    }

    public String getAlamat() {
        return alamatTextField.getText();
    }

    public int getSelectedJenisMemberId() {
        return ((JenisMember) jenisMemberComboBox.getSelectedItem()).getId();
    }
}