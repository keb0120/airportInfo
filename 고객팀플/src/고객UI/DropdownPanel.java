package 고객UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DropdownPanel extends JPanel {

    JComboBox<String> country, continent, airport;
    JButton dropdownBtn;
    DBTest dbtest = new DBTest();
    
    public DropdownPanel() {

        this.country = new JComboBox<>();
        this.continent = new JComboBox<>();
        this.airport = new JComboBox<>();
        // country db에서 받아넣기
        //https://ssg4089.tistory.com/15 콤보박스 관
        String[] countryArr = {"한국", "중국"};
        String[] airportArr = {"국제공항", "국내공함"};
      
        String[] continentArr = dbtest.getRegions();
        
        for (String str : continentArr) {
            continent.addItem(str);
            
        }
        for (String str : countryArr) {
            country.addItem(str);
        }
        for (String str : airportArr) {
            airport.addItem(str);
        }
        
        country.setMaximumSize(new Dimension(115, 100));
        continent.setMaximumSize(new Dimension(115, 100));
        airport.setMaximumSize(new Dimension(115, 100));

        continent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox) e.getSource();
				String index = cb.getSelectedItem().toString();
				System.out.println(index);
			}
		});
        
        this.dropdownBtn = new JButton("검색");

        this.add(country);
        this.add(continent);
        this.add(airport);
        this.add(dropdownBtn);
    }

}
