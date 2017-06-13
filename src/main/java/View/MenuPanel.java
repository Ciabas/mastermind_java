package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

	private MainView mainView;

	public MenuPanel(MainView mainView) {
		this.mainView = mainView;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton btnVsKomputer = new JButton("vs Komputer");
		btnVsKomputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAndChangeToVsComputerPanel();
			}
		});
		btnVsKomputer.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnVsKomputer);
		
		JButton btnVsGracz = new JButton("vs Gracz");
		btnVsGracz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAndChangeToVsPlayerPanel();
			}
		});
		btnVsGracz.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnVsGracz);

	}
	
	private void CreateAndChangeToVsComputerPanel(){
		VsComputerPanel vsComputer = new VsComputerPanel(mainView);
		mainView.PanelChanger(vsComputer, 220, 100);
	}

	private void CreateAndChangeToVsPlayerPanel(){
		System.out.println("wlazlem");
		VsPlayerPanel vsPlayer = new VsPlayerPanel(mainView);
		System.out.println("stworzylem");
		mainView.PanelChanger(vsPlayer, 300, 50);
	}
}
