import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int length = arr.length;
        int[] evenArr = new int[(length + 1) / 2];
        int i;
        int j;
        for (i = 0, j = 0; i < length; i += 2, j++) {
            evenArr[j] = arr[i];
        }
        int[] oddArr = new int[length / 2];
        for (i = 1, j = 0; i < length; i += 2, j++) {
            oddArr[j] = arr[i];
        }

        Arrays.sort(evenArr);
        System.out.println(Arrays.toString(evenArr));

        Arrays.sort(oddArr);
        System.out.println(Arrays.toString(oddArr));
    }
}
