package sorting;
import java.util.Arrays;
import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Before Sort");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr,n);

        System.out.println("After Sort");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
    public static void bubbleSort(int arr[], int n){
        for (int i = 0; i < n; i++) {
            boolean isSwap = false;
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    isSwap = true;
                    swap(arr,j,j+1);
                }
            }
            if(!isSwap){
                break;
            }
            System.out.println("run");
        }
    }

    public static void swap(int []arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
