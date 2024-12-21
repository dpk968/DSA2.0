package basicsWarmUp;
import java.util.Scanner;

public class PalindromeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(palindromeNumber(sc.nextInt()));
        sc.close();

    }
    public static boolean palindromeNumber(int n){
        
        String str = String.valueOf(n);
        int s = 0;
        int e = str.length()-1;

        while (s<e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
}
