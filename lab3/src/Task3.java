import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.println(Arrays.toString(getPostfixSumArray(arr)));
    }

    public static int[] getPostfixSumArray(int[] arr) {
        int[] postfixArr = new int[arr.length];
        postfixArr[arr.length - 1] = arr[arr.length - 1];
        for (int j = arr.length - 2; j >= 0; j--) {
            postfixArr[j] = arr[j] + postfixArr[j + 1];
        }
        return postfixArr;
    }
}
