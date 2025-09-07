package ll;

public class SortLinkedList {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        Node head = ArrayToLinkedList.arr2ll(arr);
        ArrayToLinkedList.printLl(head);
        // head = sortLinkedList(head);
        ArrayToLinkedList.printLl(head);
    }
}
