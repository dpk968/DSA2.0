public class Test implements B{

    public static void main(String[] args) {
        System.out.println("hello");
        Test a = new Test();
        a.walk();
    }

//    @Override
//    public void walk() {
//        A.super.walk();
//    }
}

interface A{
    default void walk(){
        System.out.println("inside A");
    }
}

interface B{
    default void walk(){
        System.out.println("inside B");
    }
}
