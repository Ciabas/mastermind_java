package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

    private final MainView mainView;

    public MenuPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton btnVsKomputer = new JButton("vs Komputer");
        btnVsKomputer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAndChangeToVsComputerPanel();
            }
        });
        btnVsKomputer.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(btnVsKomputer);

        JButton btnVsGracz = new JButton("vs Gracz");
        btnVsGracz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAndChangeToVsPlayerPanel();
            }
        });
        btnVsGracz.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(btnVsGracz);
    }

    private void createAndChangeToVsComputerPanel(){
        VsComputerPanel vsComputer = new VsComputerPanel(mainView);
        mainView.panelChanger(vsComputer, 200, 80);
    }

    private void createAndChangeToVsPlayerPanel(){
        VsPlayerPanel vsPlayer = new VsPlayerPanel(mainView);
        mainView.panelChanger(vsPlayer, 300, 50);
    }
}
