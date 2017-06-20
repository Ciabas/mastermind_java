package Model;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JLabel;

public class Countdown {
	
    private int timeLeft = 60;
    private Timer timer = new Timer(0, null);
    
    public int getTimeLeft() {
        return timeLeft;
    }
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
	
    public void createAndStart(final JLabel label, final int timeInSec){
        this.timer = new Timer(1000, new ActionListener() {
            private int count = timeInSec;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count <= 0) {
                    label.setText("KONIEC");
                    ((Timer)e.getSource()).stop();
                    count = 5;
                } else {
                    label.setText(Integer.toString(count));
                    count--;
                    timeLeft=count;
                }
            }
        });
        timer.start();
    }

    public void stop(){
        this.timer.stop();
    }
}
