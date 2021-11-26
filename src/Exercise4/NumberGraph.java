package Exercise4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

//Maybe a confusing name, could be renamed something better
public class NumberGraph extends MouseAdapter  {

    public static void main(String[] args) {
        //Here is the "model"/subject which the observers rely on to update them
        NumberModel numbers = new NumberModel();

        BarObserver b1 = new BarObserver(numbers);
        NumberObserver o1 = new NumberObserver(numbers);

        //Set up an array with 10 random values
        int[] numArray = new int[10];
        Random r = new Random();
        for (int i = 0; i <10 ; i++) {
            numArray[i] = r.nextInt(10);
        }

        //Set first one
        numbers.setNumbers(numArray);

        o1.jta.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //Just update if there is a inserted value
                somethingHappened();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            public void somethingHappened() {
                //Read in what is currently in the textarea
                String temp = o1.getTextArea().getText();

                //Split up each time there is a new line and create a array of it
                String[] arrayTemp = temp.split("\n");

                //for incrementing the array
                int counter = 0;

                //"converting" the strings into integers and inserting in original array
                for (String s: arrayTemp) {
                    //Debugging aid
                    if(counter>=10) System.out.println("Something is wrong");
                    System.out.print(" "+s);

                    //Assume that everything that isn't a number is 0
                    if(s.matches("[0-99]")) {
                        numArray[counter] = Integer.parseInt(s);
                    }else{
                        numArray[counter]=0;
                    }
                    counter++;
                }

                //Set the new Array which will update the observers
                numbers.setNumbers(numArray);
            }

        });



        //Tracks where the mouse goes and acts accordingly
        b1.getBarPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Find the relevant index and only change that one
                numArray[(int)(e.getX()/30)] = (int) (e.getY()/30);
                numbers.setNumbers(numArray);
            }
        });



    }


}
