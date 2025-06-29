package ll;

public class ArrayToDoublyLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = arr2Dll(arr);

        ArrayToLinkedList.printLl(head);

    }
    public static Node arr2Dll(int[] arr){
        if(arr == null || arr.length==0 ){
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            newNode.prev = temp;
            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }
}
