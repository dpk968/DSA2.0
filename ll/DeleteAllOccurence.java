package ll;

public class DeleteAllOccurence {
    public static void main(String[] args) {
        int[] arr  = {3,5,6,3,2,1,3};

        Node head = ArrayToDoublyLL.arr2Dll(arr);

        ArrayToLinkedList.printLl(head);

        head = deleteAllOccrenceOfK(head,3);
        ArrayToLinkedList.printLl(head);
    }
    public static Node deleteAllOccrenceOfK(Node head, int k){
        if (head==null || (head.next == null && head.data==k)) {
            return null;
        }

        Node temp = head;
        while (temp!=null) {
            if (temp.data==k) {
                Node prev = temp.prev;
                Node next = temp.next;
                if(prev!=null){
                    prev.next = next;
                }else{
                    head = head.next;
                }
                if(next!=null){
                    next.prev = prev;
                }
                temp = next;
                
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
