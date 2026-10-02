import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        /*
        Дано вещественное число А и целое число N (> 0). Используя один цикл,
        найти значение выражения без условного оператора: А - А^2 + A^3 + ... + (-1)^N * A^N.
         */
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter a (double), n (int).");

        System.out.print("Enter a: ");
        double a;
        if (scanner.hasNextDouble()) {
            a = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Excepted a double.");
            return;
        }

        System.out.print("Enter n: ");
        int n;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Excepted an integer.");
            return;
        }

        if (n <= 0) {
            System.out.println("Invalid input. Excepted n > 0.");
            return;
        }

        double result = 0;
        double current = a;
        while (n-- > 0) {
            result += current;
            current *= -a;
        }
        System.out.print("Result: " + result);
    }
}
