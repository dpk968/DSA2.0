package basicsWarmUp;
import java.util.Scanner;
import java.lang.Math;
public class ArmStrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(checkArmstrong(n));
        sc.close();

    }
    public static boolean checkArmstrong(int n){
        int tmp = n;
		int rem = 0;
		int sum = 0;
		int len = String.valueOf(n).length();
		while(n>0){
			rem = n%10;
			sum += Math.pow(rem, len);
			n = n/10;
		}
		if(sum == tmp) return true;
		return false;
	}
}
