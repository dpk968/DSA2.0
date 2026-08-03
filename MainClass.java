public class MainClass{


    public static void main(String[] args) throws CustCheckedExcp {

        method();
        
    }


    public static void method() throws CustCheckedExcp{
        
        System.out.println("devyani");
        throw new CustCheckedExcp("cust excep");

    }


}



class CustCheckedExcp extends Exception{
    CustCheckedExcp(String msg){
        super(msg);
    }
}