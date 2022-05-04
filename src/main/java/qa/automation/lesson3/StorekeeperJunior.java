package qa.automation.lesson3;

import java.util.ArrayList;

public class StorekeeperJunior extends Storekeeper {

    StorekeeperJunior(){
        super();
    }

    public void bubbleSort(ArrayList<Integer> data) {
//        long startTime = System.currentTimeMillis();
        for (int i = 0; i < data.size() - 1; i++){
            for (int j = 0; j < data.size() - 1 - i; j++){
                if (data.get(j+1) < data.get(j)){
                    int tmp = data.get(j+1);
                    data.set(j+1, data.get(j));
                    data.set(j, tmp);
                }
            }
        }
//        System.out.printf("Затраченное время на сортировку пузырьком = %d мс\n", System.currentTimeMillis() - startTime);
    }
}
