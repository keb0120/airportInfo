package 고객UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DropdownPanel extends JPanel {
    String[] countryArr;
    JComboBox<String> country, continent, airport;
    JButton dropdownBtn;
    DBTest dbtest = new DBTest();
    
    public DropdownPanel() {

        this.country = new JComboBox<>();
        this.continent = new JComboBox<>();
        this.airport = new JComboBox<>();

        String[] continentArr = dbtest.getContinentData();
        String[] airportArr = {"전체공항", "국제공항"};       
        
        country.setMaximumSize(new Dimension(115, 100));
        continent.setMaximumSize(new Dimension(115, 100));
        airport.setMaximumSize(new Dimension(115, 100));

        continent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox) e.getSource();
				String index = cb.getSelectedItem().toString();
				switch(index) {
					case "유럽":
						country.removeAllItems();
						countryArr = dbtest.getData("유럽");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "아프리카":
						country.removeAllItems();
						countryArr = dbtest.getData("아프리카");	
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "중동": 
						country.removeAllItems();
						countryArr = dbtest.getData("중동");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "북미":
						country.removeAllItems();
						countryArr = dbtest.getData("북미");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "남미":
						country.removeAllItems();
						countryArr = dbtest.getData("남미");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "중남미":
						country.removeAllItems();
						countryArr = dbtest.getData("중남미");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "아시아":
						country.removeAllItems();
						countryArr = dbtest.getData("아시아");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
					case "대양주":
						country.removeAllItems();
						countryArr = dbtest.getData("대양주");
				        for (String str : countryArr) {
				            country.addItem(str);            
				        }
						break;
				}
			}
		});        
        for (String str : continentArr) {
            continent.addItem(str);
        }
        for (String str : airportArr) {
            airport.addItem(str);
        }

        this.dropdownBtn = new JButton("검색");

        this.add(continent);
        this.add(country);
        this.add(airport);
        this.add(dropdownBtn);
    }

}