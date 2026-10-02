import java.util.Scanner;

import static java.lang.Math.*;


public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double result = pow(cos(x), 3) - sin(2 * x) + (cos(x) / sin(x));
        System.out.println(result);
    }
}