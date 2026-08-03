class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int r = arr.length;
        int c = arr[0].length;

        int l = 0;
        int h = (r * c) - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            int row = mid/c;
            int col = mid%c;

            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return false;
    }
}