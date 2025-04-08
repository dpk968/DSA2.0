package binarySearch;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] arr = {21212,10101,12121};
        int target = 1000000;
        System.out.println(smallestDivisor(arr, target));

    }
    public static boolean isPossible(int val, int[] arr, int target){
        int ans = 0;
        for(int i:arr){
            if(i%val == 0){
                ans += i/val;
            }else{
                ans += (i/val +1);
            }
            // ans += Math.ceil(i/val);
            if(ans>target ) return false;
        }
        return true;
    }
    public static int smallestDivisor(int[] arr, int target) {
        int low = 1;
        int high = -1;
        for(int i:arr) if(high<i) high = i;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(mid,arr,target)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
}
