package basicsWarmUp;
import java.util.*;
import java.util.Scanner;

public class PrintAllDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(sumAllDivisor(sc.nextInt()));
        }
        sc.close();
    }

    public static int sumAllDivisor(int n){
        int sum =0;
        for (int k = 1; k <= n; k++) {
            sum += sumOfDivisor(k);
        }
        return sum;
    }

    public static int sumOfDivisor(int n){
        int sum = 0;
        for (int i = 1; i*i <= n; i++) {
            if (n%i == 0) {
                sum += i;
                if(i*i != n){
                    sum += (n/i);
                }
            }
        }
        return sum;
    }
    public static void printAllDivisor(int n){

        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i*i <= n; i++) {
            if (n%i == 0) {
                arr.add(i);
                if(i*i != n){
                    arr.add(n/i);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr);

    }
}
