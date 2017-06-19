package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Model.Board;

public class MainView {

    private JFrame frame;
    private Board board;


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView window = new MainView();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createAndChangeToMenuPanel();
    }

    private void createAndChangeToMenuPanel(){
        MenuPanel menu = new MenuPanel(this);
        panelChanger(menu, 100, 50);
    }

    public void panelChanger(JPanel panel, int x, int y){
        x += 200;
        y += 200;
        frame.setContentPane(panel);
        frame.setBounds(200, 200, x, y);
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
