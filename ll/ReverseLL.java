package ll;

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = {9, 12, 31, 14, 5};
        Node head = ArrayToLinkedList.arr2ll(arr);

        ArrayToLinkedList.printLl(head);
        head = reverseLL(head);
        ArrayToLinkedList.printLl(head);
    }

    public static Node reverseLL(Node head){
        
        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (next!=null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;
        return curr;
    }
}
