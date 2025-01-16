package view.member;

import dao.JenisMemberDao;
import dao.MemberDao;
import model.JenisMember;
import model.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberButtonSimpanActionListener implements ActionListener {
    private final MemberFrame memberFrame;
    private final MemberDao memberDao = new MemberDao();
    private final JenisMemberDao jenisMemberDao = new JenisMemberDao();

    public MemberButtonSimpanActionListener(MemberFrame memberFrame) {
        this.memberFrame = memberFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = memberFrame.getId();
        String nama = memberFrame.getNama();
        String alamat = memberFrame.getAlamat();
        JenisMember jenisMember = jenisMemberDao.selectById(memberFrame.getSelectedJenisMemberId());

        if (nama.trim().isEmpty() || alamat.trim().isEmpty()) {
            JOptionPane.showMessageDialog(memberFrame, "Nama dan alamat harus diisi.");
            return;
        }

        Member member = new Member();
        member.setId(id);
        member.setNama(nama);
        member.setAlamat(alamat);
        member.setJenisMember(jenisMember);

        if (id == 0) {
            memberDao.insert(member);
        } else {
            memberDao.update(member);
        }

        memberFrame.dispose();
        memberFrame.getMemberTableFrame().refreshTable();
    }
}