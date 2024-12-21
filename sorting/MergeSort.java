package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort{
    public static void main(String[] args) {
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before sort");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,n-1);

        System.out.println("After sort");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    public static void mergeSort(int[] arr, int l, int r){
        // Write your code here
        ms(arr,l,r);

    }
    public static void ms(int[] arr, int l, int r){
        if(l>=r) return;
        int mid = (l+r)/2;
        ms(arr,l,mid);
        ms(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static void merge(int arr[], int low,int mid,int high){
        int left  = low;
        int right = mid+1;

        List<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while(right<=high){
            temp.add(arr[right]);
            right++;
        }


        // for(int i = low; i <= high; i++){
        //     arr[i] = temp.get(i - low);
        // }

        for(int i:temp){
            arr[low] = i;
            low++;
        }


    }
}