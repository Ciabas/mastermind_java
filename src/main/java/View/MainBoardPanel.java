package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Order;
@
SuppressWarnings("serial")
public class MainBoardPanel extends JPanel implements ActionListener {

    private MainView mainView;
    private int i = 0;
    private int y = 20;
    private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.PINK};
    private JButton[] buttons;
    private int playersattemps = 0;

    public MainBoardPanel(final MainView mainView) {
        this.mainView = mainView;
        setLayout(null);


        JLabel label = new JLabel("");
        label.setBounds(550, 10, 40, 25);
        add(label);
        mainView.getBoard().getCountdown().createAndStart(label, mainView.getBoard().getDifficulty().getTime());


        final JLabel statusAttemps;
        statusAttemps = new JLabel("Pozostało prób " + (mainView.getBoard().getDifficulty().getAttempts() - playersattemps));
        statusAttemps.setBounds(400, 30, 100, 30);
        add(statusAttemps);


        buttonsCreator(y);

        JButton btnSprawdz = new JButton("Sprawdz");
        btnSprawdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playersattemps == mainView.getBoard().getDifficulty().getAttempts()){
                    JOptionPane.showMessageDialog(null, "Koniec gry. \nLimit prób przekroczony");
                    mainView.getBoard().getCountdown().stop();
                    throw new Exception("KONIEC WIN");
                    return;
                }
                playersattemps += 1;
                Order playerOrder = mainView.getBoard().getPlayerOrder();
                Order rightOrder = mainView.getBoard().getRightOrder();
                int columns =  mainView.getBoard().getRightOrder().getColumnsNumber();
                Color playerOrderColors[] = new Color[columns];
                for (int j = 0; j < columns; j++){
                    playerOrderColors[j] = buttons[j].getBackground();
                    buttons[j].setEnabled(false);
                }
                mainView.getBoard().getPlayerOrder().setOrder(playerOrderColors);
                int amountOfRightColors = mainView.getBoard().getPlayerOrder().checkColors(playerOrder, rightOrder);
                boolean[] checkForRightSpots = mainView.getBoard().getPlayerOrder().checkSpots(playerOrder, rightOrder);

                JLabel check = new JLabel(Arrays.toString(checkForRightSpots).trim() + " Kolory: " + amountOfRightColors);
                check.setBounds(50, y+25, 400, 20);
                add(check);
                if (playerOrder.compareWith(rightOrder.getOrder()) == true){
                    mainView.getBoard().getCountdown().stop();
                    JOptionPane.showMessageDialog(null, "Udało Ci się, gratulacje.");
                }

                statusAttemps.setText("Pozostało prób " + (mainView.getBoard().getDifficulty().getAttempts() - playersattemps));

                y +=55;
                buttonsCreator(y);
                mainView.getFrame().validate();
                mainView.getFrame().repaint();
            }
        });
        btnSprawdz.setBounds(400, 15, 90, 25);
        add(btnSprawdz);
    }


    private void buttonsCreator(int y){
        int columns = mainView.getBoard().getRightOrder().getColumnsNumber();
        buttons = new JButton[columns];
        for (int j = 0; j < columns; j++){
            JButton btn = new JButton("");
            buttons[j] = btn;
            btn.addActionListener(this);

            btn.setBounds(50+(34*j), y, 30, 30);
            add(btn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        if (i > colors.length - 1){
            i = 0;
        }
        src.setBackground(colors[i]);
        src.setForeground(colors[i]);
        src.setOpaque(true);
        src.setBorderPainted(false);
        i++;
    }
}
