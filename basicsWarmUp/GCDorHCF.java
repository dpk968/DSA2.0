package basicsWarmUp;
import java.util.Scanner;

public class GCDorHCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(calcGCD(sc.nextInt(),sc.nextInt()));
        sc.close();
    }
    public static int calcGCD(int a, int b){
        // Write your code here.
        while (a > 0 && b > 0) {
            if (a>b) {
                a = a % b;
            }else{
                b = b % a;
            }

            if (a==0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
        }
        return -1;
    }
}
