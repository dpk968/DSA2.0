package ll;

public class ArrayToLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node n = arr2ll(arr);
        // printLl(n);
        System.out.println(getLength(n));

        System.out.println(findElement(n,2));


    }

    public static boolean findElement(Node head,int k){
        if(head!=null){
            Node tmp = head;
            while (tmp!=null) {
                if (tmp.data==k) {
                    return true;
                }
                tmp = tmp.next;
            }
        }
        return false;
    }

    public static int getLength(Node head){
        int cnt =0;
        if (head!=null) {
            Node temp = head;
            while(temp!=null){
                cnt++;
                temp=temp.next;
            }
        }
        return cnt;
    }

    public static void printLl(Node head){
        if (head!=null) {
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
        System.out.println();
    }

    public static Node arr2ll(int[] arr){
        if(arr == null || arr.length==0 ){
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }
    

    
}
