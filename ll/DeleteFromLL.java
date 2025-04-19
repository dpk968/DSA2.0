package ll;

public class DeleteFromLL {
    public static void main(String[] args) {
        System.out.println("Delete an element from linked List");
        int[] arr = {9, 12, 31, 14, 5};
        Node head = ArrayToLinkedList.arr2ll(arr);
        ArrayToLinkedList.printLl(head);
        // head = deleteFromStart(head);
        // ArrayToLinkedList.printLl(head);
        // head = deleteFromEnd(head);
        // ArrayToLinkedList.printLl(head);

        head = deleteKthElement(head,3);
        ArrayToLinkedList.printLl(head);

        head = deleteElement(head,12);
        ArrayToLinkedList.printLl(head);

    }

    public static Node deleteElement(Node head, int data){
        if (head.data==data) {
            head=head.next;
        }
        Node cur = head.next;
        Node prev = head;
        while (cur!=null) {
            if (cur.data==data) {
                prev.next = cur.next;
                break;
            }
            cur = cur.next;
            prev = prev.next;
        }
        return head;
    }

    public static Node deleteKthElement(Node head,int k){
        if(head == null) return null;
        if(k==1){
            head = head.next;
        }
        int tmpK = 2;
        Node cur = head.next;
        Node prev = head;
        while (cur!=null) {
            if (tmpK==k) {
                prev.next = cur.next;
                break;
            }
            tmpK++;
            cur = cur.next;
            prev = prev.next;
        }
        return head;
    }
    public static Node deleteFromStart(Node head){
        if (head==null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deleteFromEnd(Node head){
        if(head==null || head.next == null){
            return null;
        }

        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }

        tmp.next = null;

        return head;
    }
}
