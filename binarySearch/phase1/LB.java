package binarySearch.phase1;

import java.util.Scanner;

public class LB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {3,5,8,15,19};

        int x = 20;

        int lb = getLB(arr,arr.length,x);
        System.out.println("Lb-> "+x+" is: "+lb);

        sc.close();
    }

    public static int getUB(int[] arr, int n, int x){
        int ans = n;

        int l=0,h=n-1;


        return n;
    }

    public static int getLB(int[] arr, int n, int x) {
        int ans = n;

        int l=0,h=n-1;

        while (l<=h) {
            int mid = (l+h)/2;

            if(arr[mid]>=x){
                h = mid-1;
                ans = mid;
            }else{
                l=mid+1;
            }
        }


        return ans;
    }
}
