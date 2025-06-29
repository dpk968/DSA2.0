package ll;

public class Move012LL {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
        Node head = ArrayToLinkedList.arr2ll(arr);
        ArrayToLinkedList.printLl(head);
        head = move012(head);
        ArrayToLinkedList.printLl(head);
    }

    public static Node move012(Node head) {
        Node zeroHead = new Node(0);
        Node oneHead = new Node(0);
        Node twoHead = new Node(0);

        Node zeroTail = zeroHead;
        Node oneTail = oneHead;
        Node twoTail = twoHead;

        while (head != null) {
            if (head.data == 0) {
                zeroTail.next = head;
                zeroTail = zeroTail.next;
            } else if (head.data == 1) {
                oneTail.next = head;
                oneTail = oneTail.next;
            } else {
                twoTail.next = head;
                twoTail = twoTail.next;
            }
            head = head.next;
        }

        zeroTail.next = oneHead.next != null ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;

        return zeroHead.next;
    }

}