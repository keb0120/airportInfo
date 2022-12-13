package 고객UI;

import 고객UI.PlaceholderTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    PlaceholderTextField searchText;
    JButton searchBtn;

    public SearchPanel() {

        searchText = new PlaceholderTextField();
        searchText.setPlaceholder("공항코드를 입력하세요");
        searchText.setColumns(20);

        searchBtn = new JButton("입력");

        searchBtn.addActionListener(new SearchBtnListener(searchText));

        this.add(searchText);
        this.add(searchBtn);
    }

    static class SearchBtnListener implements ActionListener {

        PlaceholderTextField placeholderTextField;

        public SearchBtnListener (PlaceholderTextField placeholderTextField) {
            this.placeholderTextField = placeholderTextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}