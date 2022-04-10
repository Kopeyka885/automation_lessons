package qa.automation.lesson3;

public class Main {

    public static void main(String[] args) {
        StorekeeperJunior storekeeperJunior = new StorekeeperJunior();
        System.out.println("Массив до сортировки: " + storekeeperJunior.getArray().toString());
        storekeeperJunior.bubbleSort(storekeeperJunior.getArray());
        System.out.println("Массив после сортировки: " + storekeeperJunior.getArray().toString());

        StorekeeperSenior storekeeperSenior = new StorekeeperSenior();
        storekeeperSenior.bubbleSort(storekeeperSenior.getArray());
        System.out.println("Массив до сортировки: " + storekeeperSenior.getArray().toString());
        storekeeperSenior.mergeSort(storekeeperSenior.getArray().stream().mapToInt(i -> i).toArray(), storekeeperSenior.CAPACITY);
        System.out.println("Массив после сортировки: " + storekeeperSenior.getArray().toString());
    }
}
