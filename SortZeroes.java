import java.util.ArrayList;
import java.util.Scanner;

public class SortZeroes {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sortArray(arr,n);
        System.out.println(arr);


    }
    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i : arr) {
            if(i==0) count0++;
            else if(i==1) count1++;
            else count2++;
        }

        arr.clear();

        for (int i = 0; i < count0; i++) {
            arr.add(0);
        }
        for (int i = 0; i < count1; i++) {
            arr.add(1);
        }
        for (int i = 0; i < count2; i++) {
            arr.add(2);
        }

    }
}
