import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int D = sc.nextInt();

        int[] a = new int[M];

        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int[][] matrix = getNewMatrix(a, M, N, D);

        for (int i = 0; i < M; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] getNewMatrix(int[] a, int M, int N, int D) {
        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            matrix[i][0] = a[i];

            for (int j = 1; j < N; j++) {
                matrix[i][j] = matrix[i][j - 1] + D;
            }
        }
        return matrix;
    }
}