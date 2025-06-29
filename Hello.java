import java.util.Scanner;

public sealed class Hello permits Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println("Hello World "+str);
        
        
        
        sc.close();
    }

}

non-sealed class Main extends Hello{

}
