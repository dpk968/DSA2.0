public class PredictTheWinner {
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(predictTheWinner(nums));
    }

    public static boolean predictTheWinner(int[] nums) {

        int l=0,r=nums.length-1;

        int diff = getScoreDiff(l,r,nums);

        return diff>=0;
    }

    public static int getScoreDiff(int l, int r, int[] nums){
        if(l==r){
            return nums[l];
        }

        int leftChose = nums[l] - getScoreDiff(l+1, r, nums);
        int rightChoose = nums[r] - getScoreDiff(l, r-1, nums);


        return Math.max(leftChose, rightChoose);
    }
}
