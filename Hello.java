
public class Hello{

    public static void main(String[] args) {
      
        System.out.println("hello");

        C c = new C();
        c.fun();
        c.run();
        c.sun();

      
}

}

class A{
    public void run(){
        System.out.println("A run");
    }
}

class B extends A{
    public void fun(){
        System.out.println("b fun");
    }
}

class C extends B{
    public void sun(){
        System.out.println("c sun");
    }
}
