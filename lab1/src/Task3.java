import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        // 5. Даны две переменные вещественного типа: A, B.
        // Перераспределить значения данных переменных так, чтобы
        // в A оказалось меньшее из значений, а в B — большее.
        // Вывести новые значения переменных A и B.
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        if (a > b) {
            double c = a;
            a = b;
            b = c;
        }
        System.out.println("min_v=" + a + "," + "max_v=" + b);
    }
}