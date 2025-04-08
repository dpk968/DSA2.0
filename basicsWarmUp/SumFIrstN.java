package basicsWarmUp;
import java.util.Scanner;

public class SumFIrstN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sumFirstN(sc.nextInt()));
        sc.close();
        
    }
    public static long sumFirstN(long n) {
        return getSum(n);
    }

    public static long getSum(long n){
        if(n == 1) return 1;
        return (n + getSum(n-1));
    }
}
