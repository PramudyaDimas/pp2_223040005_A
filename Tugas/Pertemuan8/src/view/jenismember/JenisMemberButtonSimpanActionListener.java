package view.jenismember;

import dao.JenisMemberDao;
import model.JenisMember;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JenisMemberButtonSimpanActionListener implements ActionListener {
    private final JenisMemberFrame jenisMemberFrame;
    private final JenisMemberDao jenisMemberDao = new JenisMemberDao();

    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame) {
        this.jenisMemberFrame = jenisMemberFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = jenisMemberFrame.getId();
        String nama = jenisMemberFrame.getNama();
        double diskon = jenisMemberFrame.getDiskon();

        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(jenisMemberFrame, "Nama harus diisi.");
            return;
        }

        try {
            JenisMember jenisMember = new JenisMember();
            jenisMember.setId(id);
            jenisMember.setNama(nama);
            jenisMember.setDiskon(diskon);

            if (id == 0) {
                jenisMemberDao.insert(jenisMember);
            } else {
                jenisMemberDao.update(jenisMember);
            }

            jenisMemberFrame.dispose();
            jenisMemberFrame.getJenisMemberTableFrame().refreshTable();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(jenisMemberFrame, "Diskon harus berupa angka.");
        }
    }
}