package qa.automation.lesson2;

import java.util.Scanner;

import static java.lang.Math.random;

public class HotColdGame {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("За какое количество попыток хотите отгадать число от 1 до 100?");
        int amountOfTries = scanner.nextInt();
        int userInput;
        final int secretNumber = 1 + (int) (random() * 100 - 1);
        System.out.printf("Загаданное число -%d , только тссс\n", secretNumber);
        while (amountOfTries-- != 0) {
            System.out.println("Ваше предположение? :)");
            userInput = scanner.nextInt();
            if (userInput > 100 || userInput < 1){
                System.out.printf("Число лежит в промежутке от 1 до 100, попытка не засчитана\n");
                amountOfTries++;
            }
            if (userInput == secretNumber) {
                System.out.println("Поздравляю, вы отгадали загаданное число!");
                return;
            } else if (userInput < secretNumber) {
                System.out.printf("Загаданное число больше, у вас осталось %d %s\n", amountOfTries, correctTriesWord(amountOfTries));
            } else {
                System.out.printf("Загаданное число меньше, у вас осталось %d %s\n", amountOfTries, correctTriesWord(amountOfTries));
            }
        }
        System.out.printf("К сожалению, вам не удалось отгадать число :(\n");
    }

    public static String correctTriesWord(int number) {
        if (number < 21 && number > 4) {
            return "попыток";
        }
        switch (number % 10) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: {
                return "попыток";
            }
            case 1: {
                return "попытка";
            }
            case 2:
            case 3:
            case 4: {
                return "попытки";
            }
        }
        return null;
    }
}
