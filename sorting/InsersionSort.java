package sorting;
import java.util.Arrays;
import java.util.Scanner;

public class InsersionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Before Sort");
        System.out.println(Arrays.toString(arr));
        insersionSort(arr, n);

        System.out.println("After Sort");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    public static void insersionSort(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j>0 && arr[j] < arr[j-1]) {
                swap(arr, j-1, j);
                j--;
                System.out.println("run..");
            }
        }


        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j > 0; j--) {
        //         if (arr[j-1] > arr[j]) {
        //             swap(arr, j-1, j);
        //         }
        //     }
        // }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
