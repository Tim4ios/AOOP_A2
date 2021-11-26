package Exercise4;

import Exercise4.NumberObserver;
import Exercise4.Subject;

import javax.swing.*;
import java.util.ArrayList;

public class NumberModel implements Subject{
    private final ArrayList<Observer> observers;
    private int[] numbers;



    public NumberModel(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void addObserver(Observer newOb) {
        observers.add(newOb);
    }

    @Override
    public void removeObserver(Observer removeOb) {
        observers.remove(removeOb);
    }

    @Override
    public void notifyObserver() {

        for(Observer observer : observers){
            observer.updateNumber(numbers);
        }
    }

    public void setNumbers(int[] changedNumbers){
        this.numbers = changedNumbers;
        notifyObserver();
    }


}