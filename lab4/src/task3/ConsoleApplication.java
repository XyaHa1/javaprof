package task3;

import java.util.Scanner;
import java.util.Locale;

public class ConsoleApplication {
    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    private static final byte MIN_OPTION = 1;
    private static final byte MAX_OPTION = 6;

    private static final Shape[] history = new Shape[20];
    private static int historySize = 0;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println(
                    """
                    \n>>> Меню
                    1. Информация о программе
                    2. Информация о разработчике
                    3. История вычислений
                    4. Выход
                    5. Выполнить расчёт (Обычный треугольник)
                    6. Выполнить расчёт (Прямоугольный треугольник)
                    """
            );

            int choice = getOption();

            switch (choice) {
                case 1 -> System.out.println("— Программа для вычисления площадей треугольников.");
                case 2 -> System.out.println("— Разработчик: Половинкин Артём, РИ-250931");
                case 3 -> printHistory();
                case 4 -> {
                    scanner.close();
                    System.out.println("— Спасибо за использование программы! Автор: Половинкин Артём.");
                    System.exit(0);
                }
                case 5 -> evalTriangle();
                case 6 -> evalRightTriangle();
            }
        }
    }

    private static int getOption() {
        int choice = 0;
        while (choice < MIN_OPTION || choice > MAX_OPTION) {
            System.out.print("> Выберите пункт меню (1-" + MAX_OPTION + "): ");
            if (scanner.hasNextLine()) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < MIN_OPTION || choice > MAX_OPTION) {
                        System.out.println("— Неверный пункт меню!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("— Некорректный ввод! Введите только число.");
                }
            }
        }
        return choice;
    }

    private static void evalTriangle() {
        System.out.println("— Расчет обычного треугольника.");
        System.out.println("— Введите длину стороны a.");
        double a = getNumber();
        if (a == 0) return;

        System.out.println("— Введите длину высоты h к a.");
        double h = getNumber();
        if (h == 0) return;

        try {
            Shape triangle = new Triangle(a, h);
            if (historySize < history.length) {
                history[historySize++] = triangle;
            }
            System.out.println("— " + triangle.getDescription());
        } catch (IllegalArgumentException e) {
            System.out.println("— Ошибка: " + e.getMessage());
        }
    }

    private static void evalRightTriangle() {
        System.out.println("— Расчет прямоугольного треугольника.");
        System.out.println("— Введите длину катета a.");
        double a = getNumber();
        if (a == 0) return;

        System.out.println("— Введите длину катета b.");
        double b = getNumber();
        if (b == 0) return;

        try {
            Shape rightTriangle = new RightTriangle(a, b);
            if (historySize < history.length) {
                history[historySize++] = rightTriangle;
            }
            System.out.println("— " + rightTriangle.getDescription());
        } catch (IllegalArgumentException e) {
            System.out.println("— Ошибка: " + e.getMessage());
        }
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
            }
        }
        return number;
    }

    private static void printHistory() {
        if (historySize == 0) {
            System.out.println("— История пуста.");
            return;
        }
        System.out.println("— Вся история вычислений (Полиморфный вызов методов):");
        for (int i = 0; i < historySize; i++) {
            System.out.printf("%d) %s\n", i + 1, history[i]);
        }
    }
}
