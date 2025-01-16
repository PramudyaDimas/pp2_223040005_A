package view.jenismember;

import model.JenisMember;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JenisMemberTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Nama", "Diskon"};
    private List<JenisMember> jenisMemberList;

    public JenisMemberTableModel(List<JenisMember> jenisMemberList) {
        this.jenisMemberList = jenisMemberList;
    }

    @Override
    public int getRowCount() {
        return jenisMemberList.size();
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
        JenisMember jenisMember = jenisMemberList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return jenisMember.getId();
            case 1:
                return jenisMember.getNama();
            case 2:
                return jenisMember.getDiskon();
            default:
                return null;
        }
    }

    public void setJenisMemberList(List<JenisMember> jenisMemberList) {
        this.jenisMemberList = jenisMemberList;
        fireTableDataChanged();
    }

    public JenisMember getJenisMember(int rowIndex) {
        return jenisMemberList.get(rowIndex);
    }
}