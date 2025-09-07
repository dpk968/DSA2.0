
public class MinStack {

    Node top;
    int size=0;

    static class Node{
        int f,s;
        Node next;
        Node(int f, int s){
            this.f=f;
            this.s=s;
        }
    }
    
    public void push(int d){
        Node newNode ;
        if (size==0) {
            newNode = new Node(d, d);
        }else{
            newNode = new Node(d, Math.min(d, top.s));
            newNode.next=top;
        }
        top = newNode;
        size++;
    } 

    public void pop(){
        if (size==0) {
            System.err.println("underflow");
            return;
        }
        top=top.next;
        size--;
    }

    public int top(){
        if (size==0) {
            return -1;
        }
        return top.f;
    }

    public int getMin(){
        if (size==0) {
            return -1;
        }
        return top.s;
    }



    public static void main(String[] args) {
        System.out.println("hello");

        MinStack st = new MinStack();
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    }


}
