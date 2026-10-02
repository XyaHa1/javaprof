import java.util.Scanner;
import java.util.Locale;

public class Task4 {
    public static void main(String[] args) {
        /*
        Описать метод, вычисляющий вторую, четвертую и
        шестую степени числа A и возвращающий их суммарное значение.
         */
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter a: ");
        double a;
        if (scanner.hasNextDouble()) {
            a = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Excepted number.");
            return;
        }

        System.out.println("Sum of powers (^2, ^4, ^6): " + sumOfPowers(a));
    }

    public static double sumOfPowers(double a) {
        double a2 = a * a;
        double a4 = a2 * a2;
        double a6 = a4 * a2;

        return a2 + a4 + a6;
    }

}
