package ll;

import java.util.Scanner;

public class InsertIntoLL {
    public static void main(String[] args) {
        System.out.println("Insert and delete an element from linked List");
        
        int[] arr = {9, 12, 31, 14, 5};
        Node head = ArrayToLinkedList.arr2ll(arr);
        ArrayToLinkedList.printLl(head);

        // head = insertAtStart(head,5);
        // ArrayToLinkedList.printLl(head);

        // head = insertAtEnd(head,15);
        // ArrayToLinkedList.printLl(head);

        // head = insertAt(head, 5, 25);
        // ArrayToLinkedList.printLl(head);

        head = insertAt(head, 1, 25);
        ArrayToLinkedList.printLl(head);

        head = insertAfter(head,31,13);
        ArrayToLinkedList.printLl(head);

    }

    public static Node insertAfter(Node head, int posE,int e){
        Node newNode = new Node(e);

        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp!=null) {
            if (temp.data==posE) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertAt(Node head, int pos,int e){
        Node newNode = new Node(e);
        if (head==null) {
            return newNode;
        }
        if (pos==1) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node curr = head.next;
        // pos = pos-1;
        Node prev = head;
        int curtPos = 2;
        while (prev!=null) {
            if (curtPos == pos) {
                // newNode.next = curr.next;
                prev.next = newNode;
                newNode.next = curr;
                // curr.next = newNode;
                break;
            }
            if(curr !=null){
                curr = curr.next;
                prev = prev.next;
                curtPos++;
            }else{
                System.out.println("not possible");
                break;
            }
        }

        return head;
    }

    public static Node insertAtEnd(Node head, int e){
        Node newNode = new Node(e);
        Node temp = head;
        if(head==null){
            return newNode;
        }

        while (temp.next !=null) {
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
        
    }

    public static Node insertAtStart(Node head, int e){
        Node newNode = new Node(e);
        newNode.next = head;
        return newNode;
    }
}
