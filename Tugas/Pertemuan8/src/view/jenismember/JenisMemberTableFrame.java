package view.jenismember;

import dao.JenisMemberDao;
import model.JenisMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JenisMemberTableFrame extends JFrame {
    private final JenisMemberDao jenisMemberDao = new JenisMemberDao();
    private final JTable jenisMemberTable;
    private final JenisMemberTableModel jenisMemberTableModel;

    public JenisMemberTableFrame() {
        this.setTitle("Daftar Jenis Member");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jenisMemberTableModel = new JenisMemberTableModel(jenisMemberDao.selectAll());
        jenisMemberTable = new JTable(jenisMemberTableModel);

        JScrollPane scrollPane = new JScrollPane(jenisMemberTable);
        JButton tambahButton = new JButton("Tambah");
        JButton ubahButton = new JButton("Ubah");
        JButton hapusButton = new JButton("Hapus");

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JenisMemberFrame(JenisMemberTableFrame.this, 0, "", 0).setVisible(true);
            }
        });

        ubahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jenisMemberTable.getSelectedRow();
                if (selectedRow >= 0) {
                    JenisMember jenisMember = jenisMemberTableModel.getJenisMember(selectedRow);
                    new JenisMemberFrame(JenisMemberTableFrame.this, jenisMember.getId(), jenisMember.getNama(), jenisMember.getDiskon()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(JenisMemberTableFrame.this, "Pilih jenis member yang akan diubah.");
                }
            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jenisMemberTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(JenisMemberTableFrame.this, "Apakah Anda yakin ingin menghapus jenis member ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JenisMember jenisMember = jenisMemberTableModel.getJenisMember(selectedRow);
                        jenisMemberDao.delete(jenisMember.getId());
                        refreshTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(JenisMemberTableFrame.this, "Pilih jenis member yang akan dihapus.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(tambahButton);
        buttonPanel.add(ubahButton);
        buttonPanel.add(hapusButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void refreshTable() {
        List<JenisMember> jenisMemberList = jenisMemberDao.selectAll();
        jenisMemberTableModel.setJenisMemberList(jenisMemberList);
    }
}