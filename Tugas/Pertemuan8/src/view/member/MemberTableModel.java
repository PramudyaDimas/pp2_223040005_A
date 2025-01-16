package view.member;

import model.Member;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MemberTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Nama", "Alamat", "Jenis Member"};
    private List<Member> memberList;

    public MemberTableModel(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public int getRowCount() {
        return memberList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = memberList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return member.getId();
            case 1:
                return member.getNama();
            case 2:
                return member.getAlamat();
            case 3:
                return member.getJenisMember().getNama();
            default:
                return null;
        }
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
        fireTableDataChanged();
    }

    public Member getMember(int rowIndex) {
        return memberList.get(rowIndex);
    }
}