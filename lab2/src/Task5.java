import java.util.Scanner;
import java.util.Locale;

public class Task5 {
    /*
    Доработайте программу из лабораторной работы 1:
    1. добавьте главное меню на основе цикла while: выполнить расчёт,
    информация о программе, информация о разработчике, выход:
    2. при ошибочном вводе предлагайте повторить ввод до получения
    корректных данных или команды выхода;
    3. выполните декомпозицию программы и реализуйте статические
    методы для отдельных частей.
     */

    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println(">>> Меню");
            System.out.println("1. Выполнить расчёт");
            System.out.println("2. Информация о программе");
            System.out.println("3. Информация о разработчике");
            System.out.println("4. Выход");

            int choice = getOption();

            switch (choice) {
                case 1: {
                    evalExpression();
                    break;
                }
                case 2: {
                    System.out.println("— Программа для вычисления площади " +
                            "треугольника по заданной стороне и высоте к ней.");
                    break;
                }
                case 3: {
                    System.out.println("— Разработчик: Половинкин Артём, РИ-250931");
                    break;
                }
                case 4: {
                    scanner.close();
                    System.out.println("— Спасибо за использование программы! Автор: Половинкин Артём.");
                    System.exit(0);
                }
                default: {
                    System.out.println("— Некорректный ввод!");
                }
            }
        }
    }

    private static int getOption() {
        int choice = 0;
        while (choice < 1 || choice > 4) {
            System.out.print("> Выберите пункт меню (1-4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 0) {
                    System.out.println("— Число не может быть отрицательным!");
                }
            } else {
                System.out.println("— Некорректный ввод!");
                scanner.next();
            }
        }

        return choice;
    }

    private static void evalExpression() {
        System.out.println("— Введите длину стороны a.");
        double a = getNumber();
        if (a == 0) return;

        System.out.println("— Введите длину высоты h к a.");
        double h = getNumber();
        if (h == 0) return;

        double s = eval(a, h);
        System.out.printf("— Площадь треугольника равна: %.2f\n", s);
    }

    private static double getNumber() {
        double number = -1;
        while (number < 0) {
            System.out.print("> Введите положительное число или 0 для отмены: ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                if (number < 0) {
                    System.out.println("— Число не может быть отрицательным!");
                }
            } else {
                System.out.println("— Некорректный ввод!");
                scanner.next();
            }
        }
        return number;
    }

    private static double eval(double a, double b) {
        return a * b / 2;
    }
}
