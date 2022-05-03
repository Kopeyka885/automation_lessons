package qa.automation.lesson1;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Input first argument: ");
                Double arg1 = scanner.nextDouble();
                System.out.println("Input second argument: ");
                Double arg2 = scanner.nextDouble();
                System.out.println("Input operation, it can be '+', '-', '*', '/':");
                char op = scanner.next().charAt(0);
                double result;
                switch (op) {
                    case ('+'): {
                        result = arg1 + arg2;
                        break;
                    }
                    case ('-'): {
                        result = arg1 - arg2;
                        break;
                    }
                    case ('*'): {
                        result = arg1 * arg2;
                        break;
                    }
                    case ('/'): {
                        result = arg1 / arg2;
                        break;
                    }
                    default: {
                        System.out.println("Unsupported operation");
                        return;
                    }
                }
                System.out.printf("Result of your expression: \n%.3f \n", result);
                System.out.println("Do you want to exit? Type 'yes' if you do or 'exit' otherwise");
                String lastStr = scanner.next();
                if (Objects.equals(lastStr, "exit")) {
                    scanner.close();
                    return;
                }
            }
        } catch (InputMismatchException ime) {
            System.out.println("Your argument isn't supported");
        } catch (Exception e) {
            System.out.println("Error during application work");
        }
    }
}