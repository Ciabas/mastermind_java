package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Board;

@SuppressWarnings("serial")
public class VsPlayerPanel extends JPanel implements ActionListener {

    private MainView mainView;
    private JButton[] buttons;
    private int i = 0;
    private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.PINK};
    private JTextField txtPlayerName;
    private int columns;
    private int difficulty;

    public VsPlayerPanel(final MainView mainView) { //FINAL UWAGA !!!
        this.mainView = mainView;
        setLayout(null);

        JLabel lblPoziomTrudnoci = new JLabel("Poziom trudności:");
        lblPoziomTrudnoci.setBounds(143, 74, 108, 14);
        add(lblPoziomTrudnoci);

        final JComboBox difficultyComboBox = new JComboBox();
        difficultyComboBox.setBounds(261, 71, 59, 20);
        difficultyComboBox.setModel(new DefaultComboBoxModel(new String[] {"Łatwy", "Średni", "Trudny"}));
        add(difficultyComboBox);

        buttonsCreator();


        JButton btnNext = new JButton("Dalej");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainView.getFrame().setVisible(false);
                //JOptionPane.showMessageDialog(null, "Gracz 1 gotów na grę ?");
                startButton(columns, difficultyComboBox);
                printGameStatus();
                createAndChangeToMainBoardPanel();
                mainView.getFrame().setVisible(true);
            }
        });
        btnNext.setBounds(208, 142, 84, 42);
        add(btnNext);

        txtPlayerName = new JTextField();
        txtPlayerName.setText("Gracz 2 name");
        txtPlayerName.setBounds(187, 111, 122, 20);
        add(txtPlayerName);
        txtPlayerName.setColumns(10);
    }

    private void buttonsCreator(){
        Object[] possibilities = {3, 4, 5, 6, 7, 8};
        this.columns = Integer.parseInt(JOptionPane.showInputDialog(
                            null,
                            "wybierz liczbe kolumn",
                            "Customized Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            possibilities[0]).toString());

        buttons = new JButton[columns];
        for (int i = 0; i < buttons.length; i++){
            JButton btn = new JButton("");
            buttons[i]  = btn;
            btn.addActionListener(this);

            btn.setBounds(50+(50*i), 10, 30, 30);
            add(btn);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
         if(i >colors.length - 1){i = 0;}
         src.setBackground(colors[i]);
         i++;
    }

    private void startButton(int columns, JComboBox difficultyComboBox){
        int difficulty = 1;
        String username = JOptionPane.showInputDialog("Gracz 1 \nPodaj swoj nick");
        switch(difficultyComboBox.getSelectedItem().toString()){
            case "Łatwy": difficulty = 1; break;
            case "Średni": difficulty = 2; break;
            case "Trudny": difficulty = 3; break;
        }
        this.difficulty = difficulty;
        createBoardAndSetToMainView(columns, difficulty, username);
    }

    private void createAndChangeToMainBoardPanel(){
        MainBoardPanel mainBoard = new MainBoardPanel(mainView);
        mainView.panelChanger(mainBoard, 400, 350);
    }

    private void createBoardAndSetToMainView(int columns,int difficulty, String username){
        mainView.setBoard(new Board(columns, difficulty, username));
        System.out.println("kolumny: " + columns + "trudnosc: " + difficulty + "nick: " + username);
        Color toRightOrder[] = new Color[columns];
        for(int j = 0; j < columns; j++){
                toRightOrder[j] = buttons[j].getBackground();
        }
        mainView.getBoard().getRightOrder().setOrder(toRightOrder);
    }

    private void printGameStatus(){
        String difficultyString = "";
        switch(this.difficulty){
            case 1: difficultyString = "Łatwy"; break;
            case 2: difficultyString = "Średni"; break;
            case 3: difficultyString = "Trudny"; break;
        }
        if(mainView.getBoard().getRightOrder().areColorsUnique()){
            JOptionPane.showMessageDialog(null, "Tryb gry: kolory bez powtarzania \nPoziom trudnosci: " + difficultyString);
        }
        else{
            JOptionPane.showMessageDialog(null, "Tryb gry: kolory się powtarzaja \nPoziom trudnosci: " + difficultyString);
        }
    }
}
