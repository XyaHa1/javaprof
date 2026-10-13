public class Task2 {
    public static void main(String[] args) {
        tests();
    }

    public static void tests() {
        System.out.println("Запуск тестов...");

        // Тест 1: Успешная перестановка
        int res1 = Task2.checkPermutationArr(5, new int[]{3, 1, 5, 2, 4});
        assert res1 == 0 : "Ошибка в тесте 1! Ожидалось 0, получено " + res1;
        System.out.println("Тест 1 пройден.");

        // Тест 2: Элемент больше N
        int res2 = Task2.checkPermutationArr(5, new int[]{1, 2, 6, 4, 5});
        assert res2 == 2 : "Ошибка в тесте 2! Ожидалось 2, получено " + res2;
        System.out.println("Тест 2 пройден.");

        // Тест 3: Дубликат
        int res3 = Task2.checkPermutationArr(5, new int[]{1, 2, 2, 4, 5});
        assert res3 == 2 : "Ошибка в тесте 3! Ожидалось 2, получено " + res3;
        System.out.println("Тест 3 пройден.");

        // Тест 4: Отсутствие элемента
        int res4 = Task2.checkPermutationArr(7, new int[]{7, 5, 1, 3, 2, 6});
        assert res4 == 4 : "Ошибка в тесте 4! Ожидалось 4, получено " + res4;
        System.out.println("Тест 4 пройден.");

        System.out.println("Все тесты пройдены!");
    }

    // return isPermutation: 0 ? the first missing
    public static int checkPermutationArr(int n, int[] arr) {
        boolean[] boolArr = new boolean[n + 1];
        int val;
        int i;
        for (i = 0; i < arr.length; i++) {
            val = arr[i];
            if (val < 1 || val > n)
                return val;
            if (boolArr[val])
                return val;
            boolArr[val] = true;
        }
        for (i = 1; i < boolArr.length; i++) {
            if (!boolArr[i]) {
                return i;
            }
        }
        return 0;
    }
}
