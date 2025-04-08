import java.util.*;

public class SortEvenOdd {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] nums = { 3, 1, 2, 4 };
        sortOddEven(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sortOddEven(int[] nums) {
        // Write your code here.
        List<Integer> oddArr = new ArrayList<>();
        List<Integer> evenArr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenArr.add(nums[i]);
            } else {
                oddArr.add(nums[i]);
            }
        }
        Collections.sort(oddArr);
        Collections.sort(evenArr);
        oddArr.addAll(evenArr);

        System.out.println(evenArr);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = oddArr.get(i);
        }
    }
}