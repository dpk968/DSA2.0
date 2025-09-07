// package stackandqueue;

public class Intro {
    public static void main(String[] args) {
        System.out.println("hello");

        // StackImplByArray st = new StackImplByArray(5);
        StackImplByLL st = new StackImplByLL();
        st.push(1);
        st.push(2);
        System.err.println(st.top());
        st.push(3);
        System.err.println(st.top());
        st.pop();
        st.pop();
        System.err.println(st.size());
    }
}

class StackImplByLL{
    int size=0;
    Node top;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    public void push(int e){
        Node newNode = new Node(e);
        if(size==0){
            top=newNode;
        }else{
            newNode.next=top;
            top=newNode;
        }
        size++;
    }

    public void pop(){
        if (size==0) {
            System.err.println("underFlow");
        }
        top=top.next;
        size--;
    }

    public int top(){
        if(size==0) return -1;
        return top.data;
    }

    public int size(){
        return size;
    }
}

class StackImplByArray{

    private final int capacity;
    private int[] arr;
    private int size=0;

    StackImplByArray(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }


    public void push(int e){
        if(size==capacity){
            System.err.println("overflow");
        }
        arr[size++]=e;
    }

    public void pop(){
        if(size==0){
            System.err.println("underflow");
        }
        size--;
    }

    public int top(){
        if(size==0){
            return -1;
        }
        return arr[size-1];
    }

    public int size(){
        return size;
    }

}
