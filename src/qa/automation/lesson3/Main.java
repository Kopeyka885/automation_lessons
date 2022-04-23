package qa.automation.lesson3;

public class Main {

    public static void main(String[] args) {
        long startTime;
        StorekeeperJunior storekeeperJunior = new StorekeeperJunior();
        System.out.println("Массив до сортировки: " + storekeeperJunior.getArray().toString());

        startTime = System.currentTimeMillis();
        storekeeperJunior.bubbleSort(storekeeperJunior.getArray());

        System.out.println("Массив после сортировки: " + storekeeperJunior.getArray().toString());
        System.out.printf("Затраченное время на сортировку пузырьком = %d мс\n", System.currentTimeMillis() - startTime);

        StorekeeperSenior storekeeperSenior = new StorekeeperSenior();
        System.out.println("Массив до сортировки: " + storekeeperSenior.getArray().toString());

        storekeeperSenior.bubbleSort(storekeeperSenior.getArray());

        startTime = System.currentTimeMillis();
        storekeeperSenior.mergeSort(storekeeperSenior.getArray().stream().mapToInt(i -> i).toArray(), storekeeperSenior.CAPACITY);

        System.out.println("Массив после сортировки: " + storekeeperSenior.getArray().toString());
        System.out.printf("Затраченное время на сортировку слиянием = %d мс\n", System.currentTimeMillis() - startTime);
    }
}
