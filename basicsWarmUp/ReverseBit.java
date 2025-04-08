package basicsWarmUp;
import java.util.Scanner;

public class ReverseBit {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            long num = sc.nextLong();
            System.out.println(reverseBits(num));
        }
        sc.close();
    }
    
    public static long reverseBits(long n) {        
        StringBuilder sb = new StringBuilder(Long.toBinaryString(n));
        sb.reverse();
        for (int i = sb.length(); i < 32; i++) {
            sb.append('0');
        }
        long ans = Long.parseLong(sb.toString(),2);
		return ans;
	}
}
