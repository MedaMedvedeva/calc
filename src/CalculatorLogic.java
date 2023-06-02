import calcExceptions.*;
import java.util.Arrays;
import java.util.List;

public class CalculatorLogic {
    public static String calc(String input) throws InvalidExpressionException, NumberOutOfRangeException, UnknownOperationException, InvalidRomanResultException {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new InvalidExpressionException("Некорректное выражение. Используйте, пожалуйста, на ввод 2 числа и один оператор. Пример:\n \"2 + 2\"");
        }

        int num1;
        int num2;
        boolean isRoman = false;

        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            num1 = romanToArabic(parts[0]);
            num2 = romanToArabic(parts[2]);
            isRoman = true;
        }

        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new NumberOutOfRangeException("Числа должны быть в диапазоне от 1 до 10.");
        }

        int result = switch (parts[1]) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new UnknownOperationException("Неизвестная операция. Используйте, пожалуйста, операторы \"+\",\"-\",\"*\",\"/\"");
        };

        if (result < 1 && isRoman) {
            throw new InvalidRomanResultException("Результат меньше 1 недопустим для римских чисел.");
        }

        return isRoman ? arabicToRoman(result) : Integer.toString(result);
    }

    private static int romanToArabic(String roman) {
        int result = 0;
        int i = 0;

        while (i < roman.length()) {
            RomanNumerals symbol = RomanNumerals.valueOf(roman.substring(i, i + 1));
            i += 1;

            if (i < roman.length()) {
                RomanNumerals nextSymbol = RomanNumerals.valueOf(roman.substring(i, i + 1));
                if (nextSymbol.value > symbol.value) {
                    result += (nextSymbol.value - symbol.value);
                    i += 1;
                } else {
                    result += symbol.value;
                }
            } else {
                result += symbol.value;
            }
        }

        return result;
    }

    private static String arabicToRoman(int number) {
        List<RomanNumerals> romanNumerals = Arrays.asList(RomanNumerals.values());

        int i = romanNumerals.size() - 1;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i >= 0)) {
            RomanNumerals currentSymbol = romanNumerals.get(i);
            if (currentSymbol.value <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.value;
            } else {
                i--;
            }
        }

        return sb.toString();
    }
}
