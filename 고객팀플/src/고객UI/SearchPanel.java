package ��UI;

import ��UI.PlaceholderTextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    PlaceholderTextField searchText;
    JButton searchBtn;

    public SearchPanel() {

        searchText = new PlaceholderTextField();
        searchText.setPlaceholder("�����ڵ带 �Է��ϼ���");
        searchText.setColumns(20);

        searchBtn = new JButton("�Է�");

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
