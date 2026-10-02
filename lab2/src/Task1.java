import java.util.Locale;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        /*
        Даны целые А и В (А < В). Вывести по возрастанию
        все числа от А до В включительно и их количество.
         */
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter two integers.");
        System.out.print("A: ");
        int a;
        if (scanner.hasNextInt()) {
            a = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        System.out.print("B: ");
        int b;
        if (scanner.hasNextInt()) {
            b = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        if (a >= b) {
            System.out.println("Expected: a < b.");
            return;
        }

        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
        System.out.printf("Count: %d\n", b - a + 1);
    }
}
