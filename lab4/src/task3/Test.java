package task3;

public class Test {
    public static void main(String[] args) {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ТРЕБОВАНИЙ ООП ===");

        Shape[] demoArray = new Shape[3];

        demoArray[0] = new Triangle(5.0, 4.0);
        demoArray[1] = new RightTriangle(3.0, 4.0);
        demoArray[2] = new Triangle(5.0, 4.0);

        System.out.println("\n1. Вызов toString():");
        for (Shape s : demoArray) {
            System.out.println(s);
        }

        System.out.println("\n2. Вызов evalArea():");
        for (int i = 0; i < demoArray.length; i++) {
            System.out.printf("Элемент [%d] площадь = %.2f\n", i, demoArray[i].evalArea());
        }

        System.out.println("\n3. Тестирование согласованности equals() и hashCode():");
        System.out.println("Сравниваем объект 0 и объект 2 (одинаковые параметры):");
        boolean isEqual02 = demoArray[0].equals(demoArray[2]);
        System.out.println("  equals(): " + isEqual02);
        System.out.println("  hashCode объекта 0: " + demoArray[0].hashCode());
        System.out.println("  hashCode объекта 2: " + demoArray[2].hashCode());

        System.out.println("Сравниваем объект 0 и объект 1 (разные типы и параметры):");
        boolean isEqual01 = demoArray[0].equals(demoArray[1]);
        System.out.println("  equals(): " + isEqual01);
    }
}
