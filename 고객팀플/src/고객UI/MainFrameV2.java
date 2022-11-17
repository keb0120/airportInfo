package 고객UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrameV2 extends JFrame {

    private JPanel contentPane;
    DropdownPanel dropdownPanel;
    SearchPanel searchPanel;
    TablePanel tabletestPanel;
    DataTablePanel datatablePanel;

    public MainFrameV2() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        this.setPreferredSize(new Dimension(800, 550));
        this.setLocation(200, 400);

        dropdownPanel = new DropdownPanel();
        searchPanel = new SearchPanel();
        tabletestPanel = new TablePanel();

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));
        jPanel1.add(dropdownPanel);
        jPanel1.add(searchPanel);
        contentPane.add(jPanel1);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));
        jPanel2.add(tabletestPanel);
        contentPane.add(jPanel2);
        jPanel2.setVisible(true);
        tabletestPanel.setVisible(false);

        dropdownPanel.dropdownBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String airport = (String) dropdownPanel.airport.getSelectedItem();
                String continent = (String) dropdownPanel.continent.getSelectedItem();
                String country = (String) dropdownPanel.country.getSelectedItem();
                tabletestPanel.setDataByDropdown(country, airport, continent); // 드롭다운 데이터를 어케 받아오는지 몰라서 일단은 보류
                tabletestPanel.setVisible(true);
            }
        });

        searchPanel.searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = searchPanel.searchText.getText();
                tabletestPanel.setDataByIATA(search); // 서치 했을때 IATA 코드
                jPanel2.setVisible(true);
            }
        });

        this.pack();
        this.setVisible(true);
    }

}

class Main4 {
    public static void main(String[] args) {
        MainFrameV2 mainFrameV2 = new MainFrameV2();
        
    }
}
