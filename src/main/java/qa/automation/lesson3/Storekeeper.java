package qa.automation.lesson3;

import java.util.ArrayList;

public abstract class Storekeeper {
    protected final int CAPACITY = 10;
    protected ArrayList<Integer> array;

    Storekeeper(){
        array = new ArrayList<>();
        for (int i = 0; i < CAPACITY; i++) {
            array.add((int) Math.round(1+ Math.random()*9));
        }
    }

    public ArrayList<Integer> getArray() {
        return array;
    }
}
