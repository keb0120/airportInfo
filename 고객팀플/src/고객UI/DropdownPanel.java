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

        String[] continentArr2 = {"유럽","아프리카","중동","북미","남미","중남미","아시아","대양주"};
        String[] continentArr = dbtest.getData("지역");
        String[] airportArr = {"국제공항", "국내공함"};
      
        String[] countryArr = dbtest.getData("한글국가명");
        
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
			}
		});
        
        this.dropdownBtn = new JButton("검색");

        this.add(country);
        this.add(continent);
        this.add(airport);
        this.add(dropdownBtn);
    }

}
