package ��UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
//���� ã�⿡ ���̴� ���̺�
public class TablePanel extends JPanel {
	static int i=0;
	static final int NAIRPORTS = 2603;
	static final int NCOL = 3;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane sc;
    DataTablePanel datatablePanel;
    ArrayList<AirportList> herelist = new ArrayList<AirportList>();
    DBTest dbtest1 = new DBTest();
    String[][] data2 = new String[NAIRPORTS][4];

    public TablePanel() {
        String[] header = { "�����̸�", "�����ڵ�(IATA)", "�����̸�", "Travel More" };

    	herelist = dbtest1.getData();
    	AirportList[] alist = herelist.toArray(new AirportList[herelist.size()]);
        for(int i =0;i<herelist.size();i++) {
        	data2[i][0] = alist[i].getKorNation();
        	data2[i][1] = alist[i].getIATACode();
        	data2[i][2] = alist[i].getKorName();
        	//button ���?��ũ?
        	//https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=highkrs&logNo=220587752871
        	data2[i][3] = alist[i].getRegion();
        }

        model = new DefaultTableModel(data2, header);

        table = new JTable(model); //

        datatablePanel = new DataTablePanel();

        sc = new JScrollPane(table);
        add(sc);

        datatablePanel.setVisible(false);
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        // �� ������ �ٿ� �� �߰�

        table.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
        table.getColumnModel().getColumn(3).setCellEditor(new TableCell());

        setBounds(0, 0, 300, 150);
    }

    @SuppressWarnings("rawtypes")

    public void JTableTravelMore() {
        sc.setVisible(false);
        add(datatablePanel);
        datatablePanel.setVisible(true);
    }

    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
        public TableCell() {	
            jb = new JButton("--->");
//            jb.putClientProperty("id", Integer.valueOf(i++));
            jb.addActionListener(e -> {
                JTableTravelMore();
//                System.out.println(jb.getClientProperty("id"));
            });
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            return jb;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            return jb;
        }
    }

    public void setDataByDropdown(String country, String airport, String continent) {

    }

    public void setDataByIATA(String airportCode) {

    }

}