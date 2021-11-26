package Exercise4;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class BarPanel extends JPanel {

    //Keep the bars in a linked list
    private List<Bar> b = new LinkedList<Bar>();

    //Class to empty Panel
    public void clearOld(){
        b.clear();
    }

    //Add bar th list
    public void addBar(Bar bar){
        b.add(bar);
    }

    @Override
    public void paint(Graphics g) {
        this.repaint();
        for (Bar bar: b) {
            bar.draw(g);
        }

    }
}
