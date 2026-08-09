class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        if(n==1){
            return;
        }
        k = k%n;
        reverseArray(nums,0,n-k-1);
        reverseArray(nums,n-k,n-1);
        reverseArray(nums,0,n-1);

    }
    public void reverseArray(int[] nums, int i, int j){
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}