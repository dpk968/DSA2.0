package ll;

public class DeleteNfromTailInLL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = ArrayToLinkedList.arr2ll(arr);
        ArrayToLinkedList.printLl(head);
        head = deleteNFromTail(head, 5);
        ArrayToLinkedList.printLl(head);
    }

    public static Node deleteNFromTail(Node head, int n) {
        if(head == null || head.next == null) {
            return null;
        }
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        
        int total = length - n;
        tmp = head;
        while (tmp != null) {
            total--;
            if (total == 0) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        if(tmp == null) {
            return head.next;
        }
        return head;
    }
}
