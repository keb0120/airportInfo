package 고객UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Airport {

    private JFrame frame;
    private JTextField search_textfield;
    private JTable table;
    private JButton DropdownSearch;
    private Choice Continents,Country,Airport;
    private DefaultTableModel model;
    private JTable table1;
    private JScrollPane sc;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Airport window = new Airport();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Airport() {
        initialize();
    }

    public void Table() {
        String []a = {"Country","City","AirportCode","AirportName","Travel More"};
        String [][]b = {{"a1","a2","a3","a4","버튼"},
                {"b1","b2","b3","b4","버튼"},
                {"c1","c2","c3","c4","버튼"},
        };


        model = new DefaultTableModel(b,a);

        table = new JTable(model); //

        sc = new JScrollPane(table);
        DefaultTableModel m = (DefaultTableModel)table.getModel();
        //맨 마지막 줄에 행 추가
        m.insertRow(m.getRowCount(), new Object[]{"d1","d2","d3","d4","버튼"});
        table.updateUI();

        table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
        table.getColumnModel().getColumn(4).setCellEditor(new TableCell());
    }

    @SuppressWarnings("rawtypes")
    public void JTableTravelMore() {
        //버튼 누르면 실행할 내용 작성

    }

    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;

        public TableCell() {
            jb = new JButton("Yes");
            jb.addActionListener(e -> {
                JTableTravelMore();
            });
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            return jb;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column ) {
            return jb;
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1200, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //검색 결과가 나오는 panel
        JPanel result_panel = new JPanel();
        result_panel.setBounds(0, 87, 1184, 674);
        frame.getContentPane().add(result_panel);
        result_panel.setLayout(null);

        JLabel lblResultPanel = new JLabel("Result Panel");
        lblResultPanel.setForeground(Color.GRAY);
        lblResultPanel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        lblResultPanel.setBounds(488, 264, 270, 98);
        result_panel.add(lblResultPanel);
        result_panel.setVisible(false);

        //검색 전 main화면 panel
        JPanel first_panel = new JPanel();
        first_panel.setBounds(0, 87, 1184, 674);
        frame.getContentPane().add(first_panel);
        first_panel.setLayout(null);

        //First Panel 확인용 label. (삭제예정)
        JLabel lblNewLabel_3 = new JLabel("First Panel");
        lblNewLabel_3.setForeground(Color.GRAY);
        lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(539, 257, 270, 98);
        first_panel.add(lblNewLabel_3);
        first_panel.setVisible(true);

        //travel more 버튼 눌렀을 때 뜨는 상단 바
        JPanel search_more_bar_panel = new JPanel();
        frame.getContentPane().add(search_more_bar_panel);
        search_more_bar_panel.setLayout(null);
        search_more_bar_panel.setBackground(Color.BLUE);
        search_more_bar_panel.setBounds(0, 0, 1184, 88);
        search_more_bar_panel.setVisible(false);

        //상단 드롭다운, 직접 검색 기능이 들어간 검색 바
        JPanel search_bar_panel = new JPanel();
        search_bar_panel.setBackground(Color.BLUE);
        search_bar_panel.setBounds(0, 0, 1184, 88);
        frame.getContentPane().add(search_bar_panel);
        search_bar_panel.setLayout(null);
        search_bar_panel.setVisible(true);

        //search_bar_panel 에 있는 직접 검색 textField
        search_textfield = new JTextField();
        search_textfield.setBounds(821, 30, 227, 48);
        search_bar_panel.add(search_textfield);
        search_textfield.setColumns(10);

        //search_bar_panel에 있는 검색 버튼
        JButton search_btn = new JButton("search");
        search_btn.setBackground(Color.LIGHT_GRAY);
        //main화면에서 직접검색 버튼 눌렀을 때
        search_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first_panel.setVisible(false);
                result_panel.setVisible(true);
            }
        });
        search_btn.setBounds(1048, 30, 66, 48);
        search_bar_panel.add(search_btn);

        //더 여행하고 싶으신가요? 라벨
        JLabel lblNewLabel = new JLabel("\uB354 \uC5EC\uD589\uD558\uACE0 \uC2F6\uC73C\uC2E0\uAC00\uC694?");
        lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(12, 10, 211, 25);
        search_more_bar_panel.add(lblNewLabel);

        //검색한 공방 이름이 들어갈 라벨. ex) 인천국제공항
        JLabel lblNewLabel_1 = new JLabel("\uC778\uCC9C\uAD6D\uC81C\uACF5\uD56D");
        lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 25));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(12, 29, 176, 48);
        search_more_bar_panel.add(lblNewLabel_1);

        //에서 갈 수 있는 주변 공항을 알려드릴게요 라벨
        JLabel lblNewLabel_2 = new JLabel("\uC5D0\uC11C \uAC08 \uC218 \uC788\uB294 \uC8FC\uBCC0 \uACF5\uD56D\uC744 \uC54C\uB824\uB4DC\uB9B4\uAC8C\uC694!");
        lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(167, 30, 642, 48);
        search_more_bar_panel.add(lblNewLabel_2);

        //result_panel 다음 주변 공항을 보여주는 panel
        JPanel nearby_panel = new JPanel();
        nearby_panel.setBounds(0, 87, 1184, 674);
        frame.getContentPane().add(nearby_panel);
        nearby_panel.setVisible(false); //result_panel에서 travel_more 버튼을 누르면 setVisible(true)

    }
}