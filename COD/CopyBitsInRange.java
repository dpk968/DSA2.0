import java.util.Scanner;

public class CopyBitsInRange {
    public static void main(String[] args) {
        System.out.println("hello world");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(copyBits(a, b, j, k));
        }
        sc.close();
    }

    public static int copyBits(int a, int b, int x, int y) {

        StringBuilder aBinary = new StringBuilder(Integer.toBinaryString(a));
		StringBuilder bBinary = new StringBuilder(Integer.toBinaryString(b));

		if(bBinary.length()<aBinary.length()){
			while(bBinary.length()<aBinary.length()){
				bBinary.insert(0,"0");
			}
		}else{
			while(aBinary.length()<bBinary.length()){
				aBinary.insert(0,"0");
			}
		}
		int n = aBinary.length();
		for(int i=x;i<=y;i++){
            if(i>=n){
                break;
            }
			String res = (Integer.parseInt(aBinary.charAt(n-i)+"") | Integer.parseInt(bBinary.charAt(n-i)+"")) +"";
			bBinary.setCharAt(n-i,res.charAt(0));
		}

		return Integer.parseInt(bBinary.toString(),2);
        // return a | b;
    }
}
