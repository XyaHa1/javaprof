import java.util.Scanner;
import java.util.Locale;

public class Task5 {
    /*
    1. Применить массивы для хранения параметров вычисления и
    передачи данных между статическими методами
    2. Выделить методы ввода, вычисления, вывода и проверки
    3. Сохранить меню и обработку ошибок.
     */

    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    private static final byte MIN_OPTION = 1;
    private static final byte MAX_OPTION = 5;

    private static final double[][] history = new double[20][3];
    private static int historySize = 0;

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
                    5. История вычислений
                    """
            );

            int choice = getOption();

            switch (choice) {
                case 1 -> evalExpression();
                case 2 -> System.out.println("— Программа для вычисления площади " +
                            "треугольника по заданной стороне и высоте к ней. Формула: S = 1/2 * a * h");

                case 3 -> System.out.println("— Разработчик: Половинкин Артём, РИ-250931");

                case 4 -> {
                    scanner.close();
                    System.out.println("— Спасибо за использование программы! Автор: Половинкин Артём.");
                    System.exit(0);
                }
                case 5 -> printHistory();
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

        double s = evalAreaTriangle(a, h);

        if (historySize < history.length) {
            history[historySize++] = new double[]{a, h, s};
        }

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

    private static double evalAreaTriangle(double a, double b) {
        return a * b / 2;
    }

    private static void printHistory() {
        if (historySize == 0) {
            System.out.println("— История пуста.");
            return;
        }
        for (int i = 0; i < historySize; i++) {
            System.out.printf(
                    Locale.US,
                    "%d) a=%.2f, h=%.2f, S=%.2f\n",
                    i + 1,
                    history[i][0],
                    history[i][1],
                    history[i][2]
            );
        }
    }
}
