package ��UI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
// �α� ���� ȭ�鿡 ���̴� ���̺�
public class DataTablePanel extends JPanel {
	
	static final int NAIRPORTS = 2603;
	static final int NCOL = 3;
    JTable dataTable;
    JLabel text;
    ArrayList<AirportList> herelist = new ArrayList<AirportList>();
    
    String[] header = { "�����", "�����ڵ�(IATA)", "���׸�" };
    String[][] data2 = new String[NAIRPORTS][NCOL];
    DBTest dbtest1 = new DBTest();
    
    public DataTablePanel() {
    	
    	herelist = dbtest1.getData();   	
    	AirportList[] alist = herelist.toArray(new AirportList[herelist.size()]);
        for(int i =0;i<herelist.size();i++) {
        	data2[i][0] = alist[i].getKorNation();
        	data2[i][1] = alist[i].getIATACode();
        	data2[i][2] = alist[i].getKorName();
        }
        dataTable = new JTable(data2 , header);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("�� ���� �ϰ� ���� ���� �����Ű���?");
        this.add(textarea);
        this.add(scrollPane);
        this.setVisible(true);
    }
}
