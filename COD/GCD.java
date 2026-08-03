public class GCD {
    public static void main(String[] args) {
        int a = 15;
        int b = 10;

        System.out.println(gcd(b, a));
  
    }

    public static int gcd(int a, int b){
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b>0) {
            int rem = a%b;
            a = b;
            b = rem; 
        }
        return a;
    }
}
