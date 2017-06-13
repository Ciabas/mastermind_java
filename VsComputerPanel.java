package View;

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

import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class VsComputerPanel extends JPanel {
	private JTextField txtUsername;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JLabel lblVsKomputer;
	private MainView mainView;

	public VsComputerPanel(MainView mainView) {
		this.mainView = mainView;
		setLayout(null);
		
		
		lblVsKomputer = new JLabel("VS KOMPUTER");
		lblVsKomputer.setBounds(139, 5, 129, 25);
		lblVsKomputer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblVsKomputer);
		
		JLabel lblIloKolumn = new JLabel("Ilość kolumn");
		lblIloKolumn.setBounds(15, 97, 80, 14);
		add(lblIloKolumn);
		
		comboBox = new JComboBox();
		comboBox.setBounds(88, 94, 37, 20);
		comboBox.setModel(new DefaultComboBoxModel(new Integer[] {3,4,5,6,7,8}));
		add(comboBox);
		
		JLabel lblPoziomTrudnoci = new JLabel("Poziom trudności");
		lblPoziomTrudnoci.setBounds(225, 97, 107, 14);
		add(lblPoziomTrudnoci);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(327, 94, 59, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Łatwy", "Średni", "Trudny"}));
		add(comboBox_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(160, 50, 86, 20);
		txtUsername.setText("name");
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(155, 147, 97, 50);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartButton();
				CreateAndChangeToMainBoardPanel();
			}
		});
		add(btnStart);

	}
	
	private void StartButton(){
		int columns =  (int) comboBox.getSelectedItem();
		int difficulty = 1;
		String username = txtUsername.getText();
		switch((String)comboBox_1.getSelectedItem()){
			case "Łatwy": difficulty = 1; break;
			case "Średni": difficulty = 2; break;
			case "Trudny": difficulty = 3; break;
		}
		CreateBoardAndSetToMainView(columns, difficulty, username);
	}
	
	private void CreateAndChangeToMainBoardPanel(){
		MainBoardPanel mainBoard = new MainBoardPanel(mainView);
		mainView.PanelChanger(mainBoard, 400, 350);
	}
	
	private void CreateBoardAndSetToMainView(int columns,int difficulty, String username){
		mainView.setBoard(new Board(columns, difficulty, username));
		System.out.println("kolumny: " + columns + "trudnosc: " + difficulty + "nick: " + username);
		mainView.getBoard().getRightOrder().setOrder(mainView.getBoard().getRightOrder().randomFromColorsWithoutRepetition(columns));
	}
	
}
