package 고객UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TablePanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane sc;
    DataTablePanel datatablePanel;

    public TablePanel() {
        String[] a = { "Country", "AirportCode", "AirportName", "Travel More" };
        String[][] b = {
                { "대한민국", "INC", "인천국제공함" },
                { "대한민국", "INC", "김포공항" },
        };

        model = new DefaultTableModel(b, a);

        table = new JTable(model); //

        datatablePanel = new DataTablePanel();

        sc = new JScrollPane(table);
        add(sc);

        datatablePanel.setVisible(false);
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        // 맨 마지막 줄에 행 추가

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
            jb.addActionListener(e -> {
                JTableTravelMore();
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