import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Привет. Это программа для вычисления площади прямоугольного треугольника.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите основание и высоту, разделяя их пробелом.");
        double a;
        double h;
        if (scanner.hasNextDouble()) {
            a = scanner.nextDouble();
            if (scanner.hasNextDouble()) {
                h = scanner.nextDouble();

                double s = a * h / 2;
                System.out.println("Площадь прямоугольного треугольника равна " + s);
            } else {
                System.out.println("Вы ввели не число (pos=2).");
            }

        } else {
            System.out.println("Вы ввели не число (pos=1).");
        }
    }
}