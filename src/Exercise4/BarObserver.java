package Exercise4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Sets up the Panel and Observes to update barpanel
public class BarObserver extends JPanel implements Observer {
    private int[] numbers;
    private final BarPanel bp = new BarPanel();


    public BarObserver(Subject NumberModel) {
        JFrame window = new JFrame("Bar diagram");
        window.setContentPane(bp);
        window.setSize(300, 350);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        NumberModel.addObserver(this);
    }

    @Override
    public void updateNumber(int[] values) {
            bp.clearOld();
            this.numbers = values;
            barchange();

    }

    //Set up what size the bars are to be before they are painted
    //this only works for the set size of the panel
    public void barchange() {
        int posX = 0;
        for (int i : numbers) {
            bp.addBar(new Bar((300 / 10) * i,30,posX,0,Color.BLACK));
            posX += 30;

        }
    }

    public BarPanel getBarPanel(){
        return bp;
    }


}
