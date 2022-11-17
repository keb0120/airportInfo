package 고객UI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
// 인근 공항 화면에 쓰이는 테이블
public class DataTablePanel extends JPanel {
    JTable dataTable;
    JLabel text;
    ArrayList<AirportList> herelist = new ArrayList<AirportList>();
    
    //2603개 공항
    String[] header = { "나라명", "공항코드(IATA)", "공항명" };
    String[][] data = {
            { "대한민국", "INC", "인천국제공함" },
            { "대한민국", "INC", "김포공항", },
    };
    AirportList[] alist = herelist.toArray(new AirportList[herelist.size()]);
//    AirportList[] alist = new AirportList[2603];
    DBTest dbtest1 = new DBTest();

    public DataTablePanel() {
    	herelist = dbtest1.getData();
    	System.out.println("데이터패널 겟데이터 완료");
    	System.out.println(herelist.size());
        dataTable = new JTable(data, header);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("더 여행 하고 싶은 곳이 있으신가요?");
        this.add(textarea);
        this.add(scrollPane);
        this.setVisible(true);
    }
}
