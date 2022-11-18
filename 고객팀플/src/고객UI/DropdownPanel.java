package ��UI;

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
        // country db���� �޾Ƴֱ�
        //https://ssg4089.tistory.com/15 �޺��ڽ� ��
        String[] countryArr = {"�ѱ�", "�߱�"};
        String[] airportArr = {"��������", "��������"};
      
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
        
        this.dropdownBtn = new JButton("�˻�");

        this.add(country);
        this.add(continent);
        this.add(airport);
        this.add(dropdownBtn);
    }

}
