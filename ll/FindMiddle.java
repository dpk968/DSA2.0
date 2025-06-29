package ll;

public class FindMiddle {
    public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5,6};

        Node head = ArrayToLinkedList.arr2ll(arr);
        
        System.out.println(findMiddle(head).data);

	}
    public static Node findMiddle(Node head) {
		if(head==null) {
			return null;
		}
		
		Node fastNode = head;
		Node slowNode = head;
		
		while(fastNode !=null && fastNode.next !=null && fastNode.next.next !=null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return slowNode;
	}
}
