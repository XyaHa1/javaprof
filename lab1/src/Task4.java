import java.util.Locale;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Привет. Это программа для вычисления площади прямоугольного треугольника.");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Введите основание и высоту, разделяя их пробелом: ");
        double a;
        if (scanner.hasNextDouble()) {
            a = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели недопустимое значение (pos=1).");
            return;
        }

        double h;
        if (scanner.hasNextDouble()) {
            h = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели недопустимое значение (pos=2).");
            return;
        }

        double s = a * h / 2;
        System.out.println("Площадь прямоугольного треугольника равна " + s);


    }
}