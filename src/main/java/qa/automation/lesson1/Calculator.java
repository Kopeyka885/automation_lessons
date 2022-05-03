package qa.automation.lesson1;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    public static Double calculate(String _arg1, String _arg2, String _operation, boolean isInterface) {

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                Double arg1;
                Double arg2;
                char op;
                if (isInterface) {
                    arg1 = Double.parseDouble(_arg1);
                    arg2 = Double.parseDouble(_arg2);
                    op = _operation.charAt(0);
                } else {
                    System.out.println("Input first argument: ");
                    arg1 = scanner.nextDouble();
                    System.out.println("Input second argument: ");
                    arg2 = scanner.nextDouble();
                    System.out.println("Input operation, it can be '+', '-', '*', '/':");
                    op = scanner.next().charAt(0);
                }
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
                        if (arg2 == 0) {
                            throw new ArithmeticException("Division on zero unsupported");
//                            System.out.println();
//                            continue;
                        } else {
                            result = arg1 / arg2;
                            break;
                        }
                    }
                    default: {
                        throw new IllegalArgumentException("Unsupported operation");
                    }
                }
                if (!isInterface && Objects.equals(scanner.next(), "exit")) {
                System.out.printf("Result of your expression: \n%.3f \n", result);
                System.out.println("Do you want to continue? Type 'yes' if you do or 'exit' otherwise");
                    scanner.close();
                    return result;
                } else if (isInterface) {
                    return result;
                }
            }
        } catch (InputMismatchException ime) {
            System.out.println("Your argument isn't supported");
        }
        catch (ArithmeticException eae){
            System.out.println("Division on zero unsupported");
        }
        catch (Exception e) {
            System.out.println("Error during application work");
        }
        return .0;
    }
}
