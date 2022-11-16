package ��UI;

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
        String[] countryArr = {"�ѱ�", "�߱�"};
        String[] continentArr = {"����", "�ƽþ�", "������ī", "���Ƹ޸�ī", "�ϾƸ޸�ī", "�����ƴϾ�"};
        String[] airportArr = {"��������", "��������"};
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

        this.dropdownBtn = new JButton("�˻�");

        this.add(country);
        this.add(continent);
        this.add(airport);
        this.add(dropdownBtn);
    }

}
