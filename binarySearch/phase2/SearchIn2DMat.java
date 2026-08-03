package binarySearch.phase2;

public class SearchIn2DMat {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] arr, int target) {
        int r = arr.length;
        int c = arr[0].length;

        int l = 0;
        int h = r - 1;
        int idx = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid][0] <= target && target <= arr[mid][c - 1]) {
                idx = mid;
                break;
            } else if (arr[mid][0] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (idx == -1)
            return false;

        int low = 0, high = c - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[idx][mid] == target)
                return true;
            else if (arr[idx][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
