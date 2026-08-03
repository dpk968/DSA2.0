import java.util.HashMap;

public class CountAtMost {

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        System.out.println(countAtMostKUnique(arr, 2));
        System.out.println(countAtMostKUnique(arr, 1));
    }

    public static int exactlyKTimes(int arr[], int k){
        return countAtMostKUnique(arr, k) - countAtMostKUnique(arr, k-1);
    }

    public static int countAtMostKUnique(int[] arr, int k) {
        int ans = 0;
        int l = 0, r = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while (map.size() > k) {
                int freq = map.get(arr[l]);
                if (freq - 1 == 0) {
                    map.remove(arr[l]);
                } else {
                    map.put(arr[l], freq - 1);
                }
                l++;
            }
            ans += r - l + 1;
            r++;

        }

        return ans;
    }
}
