package 고객UI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
// 인근 공항 화면에 쓰이는 테이블
public class DataTablePanel extends JPanel {
	
	static final int NAIRPORTS = 2603;
	static final int NCOL = 3;
    private JScrollPane sc;
    JTable dataTable;
    JLabel text;
    ArrayList<AirportList> herelist = new ArrayList<AirportList>();
    AirportList[] alist;
	String[][] data2 = new String[NAIRPORTS][NCOL];
    String[] header = { "나라명", "공항코드(ICAO)", "공항명" };
    
    DBTest dbtest1 = new DBTest();
    
    public DataTablePanel() {
    	//테스트용 임의값
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
        sc = new JScrollPane(dataTable);
        JLabel textarea = new JLabel("더 여행 하고 싶은 곳이 있으신가요?");
        this.add(textarea);
        this.add(sc);
        this.setVisible(true);
    }
    public DataTablePanel(String paramCode) {
    	if(paramCode == null) {
    		System.out.println("updatepanel error");
    	}else {
    		//테스트용 임의 값 설정
    		herelist = dbtest1.getDataByNearby(paramCode);
			alist = herelist.toArray(new AirportList[herelist.size()]);
		    for(int i =0;i<herelist.size();i++) {
		    	data2[i][0] = alist[i].getKorNation();
		    	data2[i][1] = alist[i].getICAOCode();
		    	data2[i][2] = alist[i].getKorName();
		    }
		    dataTable = new JTable(data2 , header);
		    if(sc !=null) {
		    	remove(sc);
		    }
		    sc = new JScrollPane(dataTable);
		    JLabel textarea = new JLabel("더 여행 하고 싶은 곳이 있으신가요?");
		    this.add(textarea);
		    this.add(sc);
		    this.setVisible(true);
    	}
    }
    
}