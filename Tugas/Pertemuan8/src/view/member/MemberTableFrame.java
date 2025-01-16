package view.member;

import dao.MemberDao;
import model.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MemberTableFrame extends JFrame {
    private final MemberDao memberDao = new MemberDao();
    private final JTable memberTable;
    private final MemberTableModel memberTableModel;

    public MemberTableFrame() {
        this.setTitle("Daftar Member");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        memberTableModel = new MemberTableModel(memberDao.selectAll());
        memberTable = new JTable(memberTableModel);

        JScrollPane scrollPane = new JScrollPane(memberTable);
        JButton tambahButton = new JButton("Tambah");
        JButton ubahButton = new JButton("Ubah");
        JButton hapusButton = new JButton("Hapus");

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MemberFrame(MemberTableFrame.this, 0, "", "", 0).setVisible(true);
            }
        });

        ubahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = memberTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Member member = memberTableModel.getMember(selectedRow);
                    new MemberFrame(MemberTableFrame.this, member.getId(), member.getNama(), member.getAlamat(), member.getJenisMember().getId()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(MemberTableFrame.this, "Pilih member yang akan diubah.");
                }
            }
        });

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = memberTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(MemberTableFrame.this, "Apakah Anda yakin ingin menghapus member ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Member member = memberTableModel.getMember(selectedRow);
                        memberDao.delete(member.getId());
                        refreshTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(MemberTableFrame.this, "Pilih member yang akan dihapus.");
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
        List<Member> memberList = memberDao.selectAll();
        memberTableModel.setMemberList(memberList);
    }
}