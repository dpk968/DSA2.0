import java.util.Arrays;
import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans[] = getSecondOrderElements(n,arr);
        
        System.out.println(Arrays.toString(ans));

        sc.close();
        
    }
    public static int[] getSecondOrderElements(int n, int []arr) {
        // Write your code here.
        int ans[] = new int[2];
        int slargest = secondLargest(arr,n);
        int sSmallest = secondSmallest(arr,n);
        ans[0] = slargest;
        ans[1] = sSmallest;

        return ans;
    }

    public static int secondLargest(int []arr, int n){
        int largest = arr[0];
        int slargest = -1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > largest){
                slargest = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > slargest){
                slargest = arr[i];
            }
        }
        return slargest;
    }

    public static int secondSmallest(int []arr, int n){
        int smallest = arr[0];
        int sSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if(arr[i] < smallest){
                sSmallest = smallest;
                smallest = arr[i];
            }else if(arr[i] > smallest && arr[i] < sSmallest){
                sSmallest = arr[i];
            }
        }
        return sSmallest;
    }
}
