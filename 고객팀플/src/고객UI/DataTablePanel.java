package ��UI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class DataTablePanel extends JPanel {
    JTable dataTable;
    JLabel text;

    String[] header = { "Country", "Airport Code", "Airport Name" };
    String[][] data = {
            { "���ѹα�", "INC", "��õ��������" },
            { "���ѹα�", "INC", "��������", },
    };

    public DataTablePanel() {
        dataTable = new JTable(data, header);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("�� ���� �ϰ� ���� ���� �����Ű���?");
        this.add(textarea);
        this.add(scrollPane);
        this.setVisible(true);
    }
}
