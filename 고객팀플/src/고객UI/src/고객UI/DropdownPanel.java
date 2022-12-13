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
				        setCountryCB("유럽");
						break;
					case "아프리카":
						setCountryCB("아프리카");
						break;
					case "중동": 
						setCountryCB("중동");
						break;
					case "북미":
						setCountryCB("북미");
						break;
					case "남미":
						setCountryCB("남미");
						break;
					case "중남미":
						setCountryCB("중남미");
						break;
					case "아시아":
						setCountryCB("아시아");
						break;
					case "대양주":
						setCountryCB("대양주");
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
    public void setCountryCB(String continentName) {
    	country.removeAllItems();
		countryArr = dbtest.getData(continentName);
        for (String str : countryArr) {
            country.addItem(str);            
        }
    }
}