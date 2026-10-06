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

    private static final byte MIN_OPTION = 1;
    private static final byte MAX_OPTION = 4;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println(
                    """
                    >>> Меню
                    1. Выполнить расчёт
                    2. Информация о программе
                    3. Информация о разработчике
                    4. Выход
                    """
            );

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
        while (choice < MIN_OPTION || choice > MAX_OPTION) {
            System.out.print("> Выберите пункт меню (" + MIN_OPTION + "-" + MAX_OPTION + "): ");
            if (scanner.hasNextLine()) {
                try {
                    choice = Byte.parseByte(scanner.nextLine());
                    if (choice <= 0) {
                        System.out.println("— Число не может быть отрицательным или нулем!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("— Некорректный ввод! Введите только число.");
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
            if (scanner.hasNextLine()) {
                try {
                    number = Double.parseDouble(scanner.nextLine());
                    if (number < 0) {
                        System.out.println("— Число не может быть отрицательным!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("— Некорректный ввод! Введите только число.");
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
