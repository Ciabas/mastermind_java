package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Board;

import java.awt.Font;

@SuppressWarnings("serial")
public class VsComputerPanel extends JPanel {
    private final JTextField txtUsername;
    private final JComboBox comboBox_1;
    private final JComboBox comboBox;
    private final JLabel lblVsKomputer;
    private final MainView mainView;

    public VsComputerPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);


        lblVsKomputer = new JLabel("VS KOMPUTER");
        lblVsKomputer.setBounds(145, 5, 155, 25);
        lblVsKomputer.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblVsKomputer);

        JLabel lblIloKolumn = new JLabel("Ilość kolorów");
        lblIloKolumn.setBounds(25, 95, 95, 15);
        add(lblIloKolumn);

        comboBox = new JComboBox();
        comboBox.setBounds(50, 115, 60, 20);
        comboBox.setModel(new DefaultComboBoxModel(new Integer[] {3,4,5,6,7,8}));
        add(comboBox);

        JLabel lblPoziomTrudnoci = new JLabel("Poziom trudności");
        lblPoziomTrudnoci.setBounds(255, 95, 110, 15);
        add(lblPoziomTrudnoci);

        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(240, 115, 115, 20);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Łatwy", "Średni", "Trudny"}));
        add(comboBox_1);

        txtUsername = new JTextField("Nazwa gracza");
        txtUsername.setBounds(150, 50, 100, 20);
        add(txtUsername);
        txtUsername.setColumns(10);

        JButton btnStart = new JButton("START");
        btnStart.setBounds(150, 150, 100, 50);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton();
                createAndChangeToMainBoardPanel();
            }
        });
        add(btnStart);
    }

    private void startButton(){
        int columns =  Integer.parseInt(comboBox.getSelectedItem().toString());
        int difficulty = 1;
        String username = txtUsername.getText();
        switch(comboBox_1.getSelectedItem().toString()){
            case "Łatwy": difficulty = 1; break;
            case "Średni": difficulty = 2; break;
            case "Trudny": difficulty = 3; break;
        }
        createBoardAndSetToMainView(columns, difficulty, username);
    }

    private void createAndChangeToMainBoardPanel(){
        MainBoardPanel mainBoard = new MainBoardPanel(mainView);
        mainView.panelChanger(mainBoard, 400, 350);
    }

    private void createBoardAndSetToMainView(int columns,int difficulty, String username){
        mainView.setBoard(new Board(columns, difficulty, username));
        mainView.getBoard().getRightOrder().setOrder(mainView.getBoard().getRightOrder().randomColorsNoReps(columns));
    }
}
