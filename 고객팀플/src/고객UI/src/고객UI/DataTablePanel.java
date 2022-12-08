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
    private JScrollPane sc;
    JTable dataTable;
    JLabel text;
    ArrayList<AirportList> herelist = new ArrayList<AirportList>();
    AirportList[] alist;
	String[][] data2 = new String[NAIRPORTS][NCOL];
    String[] header = { "�����", "�����ڵ�(ICAO)", "���׸�" };
    
    DBTest dbtest1 = new DBTest();
    
    public DataTablePanel() {
    	//�׽�Ʈ�� ���ǰ�
//    	herelist = dbtest1.getDataByNearby("OMAA");
    	herelist = dbtest1.getData();
    	alist = herelist.toArray(new AirportList[herelist.size()]);
        for(int i =0;i<herelist.size();i++) {
        	data2[i][0] = alist[i].getKorNation();
        	data2[i][1] = alist[i].getIATACode();
        	data2[i][2] = alist[i].getKorName();
        }
        dataTable = new JTable(data2 , header);
        if(sc !=null) {
        	remove(sc);
        }
//        JScrollPane scrollPane = new JScrollPane(dataTable);
        sc = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("�� ���� �ϰ� ���� ���� �����Ű���?");
        this.add(textarea);
        this.add(sc);
        this.setVisible(true);
    }
    public DataTablePanel(String paramCode) {
//	3. updatePanel �޼��带 ����Ϸ� ������ ������ �־�� �����ڷ� �ٽ� ���� �׷��� ���� ������ �߻�. scrollpane�� add�ϴ� �������� ������ ��������?
    	if(paramCode == null) {
    		System.out.println("updatepanel error");
    	}else {
    		//�׽�Ʈ�� ���� �� ����
    		herelist = dbtest1.getDataByNearby("OMDB");
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
    
}
