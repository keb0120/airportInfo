package ��UI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
// �α� ���� ȭ�鿡 ���̴� ���̺�
public class DataTablePanel extends JPanel {
    JTable dataTable;
    JLabel text;
    ArrayList<AirportList> herelist = new ArrayList<AirportList>();
    
    //2603�� ����
    String[] header = { "�����", "�����ڵ�(IATA)", "���׸�" };
    String[][] data = {
            { "���ѹα�", "INC", "��õ��������" },
            { "���ѹα�", "INC", "��������", },
    };
    AirportList[] alist = herelist.toArray(new AirportList[herelist.size()]);
//    AirportList[] alist = new AirportList[2603];
    DBTest dbtest1 = new DBTest();

    public DataTablePanel() {
    	herelist = dbtest1.getData();
    	System.out.println("�������г� �ٵ����� �Ϸ�");
    	System.out.println(herelist.size());
        dataTable = new JTable(data, header);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("�� ���� �ϰ� ���� ���� �����Ű���?");
        this.add(textarea);
        this.add(scrollPane);
        this.setVisible(true);
    }
}
