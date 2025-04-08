import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


       System.out.println(Arrays.toString(moveZeros(arr,n)));

       sc.close();

    }
    public static int[] moveZeros(int []arr, int n) {
        // Write your code here.
        int j = 0; 
        for (int i = 0; i < n; i++) { 
            if (arr[i] != 0) { 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++; 
            } 
        } 

        return arr;
    }
    public static void swap(int[] arr, int a, int b) 
    { 
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp; 
    } 
}
