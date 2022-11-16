package 고객UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownPanel extends JPanel {

    JComboBox<String> country, continent, airport;
    JButton dropdownBtn;

    public DropdownPanel() {

        this.country = new JComboBox<>();
        this.continent = new JComboBox<>();
        this.airport = new JComboBox<>();
        String[] countryArr = {"한국", "중국"};
        String[] continentArr = {"유럽", "아시아", "아프리카", "남아메리카", "북아메리카", "오세아니아"};
        String[] airportArr = {"국제공항", "국내공함"};
        for (String str : countryArr) {
            country.addItem(str);
        }
        for (String str : continentArr) {
            continent.addItem(str);
        }
        for (String str : airportArr) {
            airport.addItem(str);
        }
        country.setMaximumSize(new Dimension(115, 100));
        continent.setMaximumSize(new Dimension(115, 100));
        airport.setMaximumSize(new Dimension(115, 100));

        this.dropdownBtn = new JButton("검색");

        this.add(country);
        this.add(continent);
        this.add(airport);
        this.add(dropdownBtn);
    }

}
