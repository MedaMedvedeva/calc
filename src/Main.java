import calcExceptions.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите выражение, в формате \"2 + 2\" (число, пробел, оператор, пробел, число), используя римские, либо арабские числа:");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("STOP")) {
                break;
            }

            try {
                System.out.println(CalculatorLogic.calc(input));
            } catch (InvalidExpressionException | NumberOutOfRangeException | UnknownOperationException | InvalidRomanResultException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
