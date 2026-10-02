import java.util.Locale;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        /*
        Дано целое число N (> 0). С помощью операций целочисленного деления
        и остатка определить, имеются ли в записи N нечётные цифры. Вывести Тrие или False.
         */
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter integer number: ");
        int n;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Excepted type of integer.");
            return;
        }
        if (n <= 0) {
            System.out.println("Invalid input. Excepted positive integer.");
            return;
        }

        System.out.println("Result: " + hasOddDigit(n));
    }

    public static boolean hasOddDigit(int n) {
        int i = n;
        while (i > 0) {
            if (i % 2 != 0) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}
