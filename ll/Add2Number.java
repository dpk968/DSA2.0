package ll;

public class Add2Number {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 6, 8};
        int[] arr2 = { 9, 6, 8 };

        Node a = ArrayToLinkedList.arr2ll(arr);
        Node b = ArrayToLinkedList.arr2ll(arr2);

        ArrayToLinkedList.printLl(a);
        ArrayToLinkedList.printLl(b);

        Node head = add2Number(a, b);
        ArrayToLinkedList.printLl(head);
    }

    public static Node add2Number(Node h1, Node h2) {

        String res = (h1.data + h2.data) + "";

        int carry = res.length() == 1 ? 0 : Integer.parseInt(res.charAt(0) + "");
        int ans = res.length() == 1 ? Integer.parseInt(res.charAt(0) + "") : Integer.parseInt(res.charAt(1) + "");
        Node head = new Node(ans);
        Node tmpHead = head;

        h1 = h1.next;
        h2 = h2.next;

        while (h1 != null && h2 != null) {
            res = (h1.data + h2.data + carry) + "";
            carry = res.length() == 1 ? 0 : Integer.parseInt(res.charAt(0) + "");
            ans = res.length() == 1 ? Integer.parseInt(res.charAt(0) + "") : Integer.parseInt(res.charAt(1) + "");
            // head = new Node(ans);

            Node tmp = new Node(ans);
            tmpHead.next = tmp;
            tmpHead = tmpHead.next;

            h1 = h1.next;
            h2 = h2.next;

        }

        while (h1 !=null) {
            res = (h1.data + carry) + "";
            carry = res.length() == 1 ? 0 : Integer.parseInt(res.charAt(0) + "");
            ans = res.length() == 1 ? Integer.parseInt(res.charAt(0) + "") : Integer.parseInt(res.charAt(1) + "");
            // head = new Node(ans);

            Node tmp = new Node(ans);
            tmpHead.next = tmp;
            tmpHead = tmpHead.next;

            h1 = h1.next;
            
        }

        while (h2 !=null) {
            res = (h2.data + carry) + "";
            carry = res.length() == 1 ? 0 : Integer.parseInt(res.charAt(0) + "");
            ans = res.length() == 1 ? Integer.parseInt(res.charAt(0) + "") : Integer.parseInt(res.charAt(1) + "");
            // head = new Node(ans);

            Node tmp = new Node(ans);
            tmpHead.next = tmp;
            tmpHead = tmpHead.next;

            h2 = h2.next;
            
        }

        return head;
    }
}
