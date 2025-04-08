package binarySearch;

public class CocoEatingBanana {
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
    public static int minEatingSpeed(int[] arr, int h) {
        int low = 1;
        int high = -1;
        for(int i:arr){
            if(i>high){
                high = i;
            }
        }
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(mid,arr,h)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));

        System.out.println(Math.ceil(7/3));
    }
}
