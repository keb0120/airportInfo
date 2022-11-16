package 고객UI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class DataTablePanel extends JPanel {
    JTable dataTable;
    JLabel text;

    String[] header = { "Country", "Airport Code", "Airport Name" };
    String[][] data = {
            { "대한민국", "INC", "인천국제공함" },
            { "대한민국", "INC", "김포공항", },
    };

    public DataTablePanel() {
        dataTable = new JTable(data, header);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("더 여행 하고 싶은 곳이 있으신가요?");
        this.add(textarea);
        this.add(scrollPane);
        this.setVisible(true);
    }
}
