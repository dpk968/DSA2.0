package basicsWarmUp;
import java.util.Scanner;

public class SumOfAllDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sumOfAllDivisors(sc.nextInt()));
        sc.close();
    }

    public static int sumOfAllDivisors(int n){
        int ans = 0;
        for (int i = 1; i*i < n; i++) {
            if (n%i == 0) {
                ans += i;
                if (n/i != i) {
                    ans += (n/i);
                }
            }
        }

        return ans;
    }
}
