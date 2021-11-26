package Exercise4;

import javax.swing.*;

public class NumberObserver extends JFrame implements Observer{
    private int[] numbers;
    public JTextArea jta;

    public NumberObserver(Subject NumberModel){
        jta = new JTextArea(20,20);
        add(jta);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NumberModel.addObserver(this);
    }

    @Override
    public void updateNumber(int[] values) {
        this.numbers = values;
        numberChange();
    }

    private void numberChange(){

        StringBuilder temp = new StringBuilder();

        for (int i:numbers) {
            temp.append(i).append("\n");
        }

        jta.setText(temp.toString());
        pack();
        setVisible(true);

        //Debugging aid
        for (int i: numbers) {
            System.out.print(i+" ");
        }
    }
    public JTextArea getTextArea(){
        return jta;
    }
}
