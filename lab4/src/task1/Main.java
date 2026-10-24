package task1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТ 1: Обычный прямоугольный треугольник ===");
        try {
            // Катеты 3 и 4, гипотенуза 5. Площадь должна быть 6, периметр 12
            Triangle normal = new Triangle(0, 0, 3, 0, 0, 4);
            System.out.println("Сторона AB: " + normal.getSideAB()); // 3.0
            System.out.println("Сторона BC: " + normal.getSideBC()); // 5.0
            System.out.println("Сторона CA: " + normal.getSideCA()); // 4.0
            System.out.println("Периметр: " + normal.perimeter());   // 12.0
            System.out.println("Площадь: " + normal.area());         // 6.0
            System.out.println("Результат: УСПЕШНО\n");
        } catch (Exception e) {
            System.out.println("Результат: ОШИБКА -> " + e.getMessage() + "\n");
        }

        System.out.println("=== ТЕСТ 2: Точки совпадают (Вырожденный) ===");
        try {
            // Две вершины находятся в одной точке (0, 0)
            Triangle invalid1 = new Triangle(0, 0, 0, 0, 5, 5);
            System.out.println("Результат: ОШИБКА (Объект создался, а должен был упасть)");
        } catch (IllegalArgumentException e) {
            System.out.println("Исключение поймано: " + e.getMessage());
            System.out.println("Результат: УСПЕШНО\n");
        }

        System.out.println("=== ТЕСТ 3: Точки на одной вертикальной прямой ===");
        try {
            // Все точки лежат на линии X = 2
            Triangle invalid2 = new Triangle(2, 1, 2, 5, 2, 10);
            System.out.println("Результат: ОШИБКА (Объект создался, а должен был упасть)");
        } catch (IllegalArgumentException e) {
            System.out.println("Исключение поймано: " + e.getMessage());
            System.out.println("Результат: УСПЕШНО\n");
        }

        System.out.println("=== ТЕСТ 4: Точки на одной наклонной прямой ===");
        try {
            // Точки лежат на диагонали Y = X
            Triangle invalid3 = new Triangle(1, 1, 3, 3, 8, 8);
            System.out.println("Результат: ОШИБКА (Объект создался, а должен был упасть)");
        } catch (IllegalArgumentException e) {
            System.out.println("Исключение поймано: " + e.getMessage());
            System.out.println("Результат: УСПЕШНО\n");
        }

        System.out.println("=== ТЕСТ 5: Тест на погрешность double (0.1 + 0.2) ===");
        try {
            // Точки лежат на одной линии Y = X, но с проблемными для double координатами
            Triangle invalid4 = new Triangle(0, 0, 0.1, 0.1, 0.2, 0.2);
            System.out.println("Результат: ОШИБКА (Объект создался, а должен был упасть из-за точности double)");
        } catch (IllegalArgumentException e) {
            System.out.println("Исключение поймано: " + e.getMessage());
            System.out.println("Результат: УСПЕШНО\n");
        }
    }
}
