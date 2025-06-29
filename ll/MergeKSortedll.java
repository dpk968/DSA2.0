package ll;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair<T1,T2> {
    T1 first;
    T2 second;
    
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}

public class MergeKSortedll {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Node head = ArrayToLinkedList.arr2ll(arr[i]);
            list.add(head);
        }

        Node head = mergeKsortedll(list);
        ArrayToLinkedList.printLl(head);

    }

    public static Node mergeKsortedll(List<Node> list) {
		if (list == null || list.size()==0) {
			return null;
		}
		
		Node dummyNode = new Node(-1);
		Node tempDummyNode = dummyNode;
		
		PriorityQueue<Pair<Integer,Node>> q = new PriorityQueue<>((a,b)->a.first.compareTo(b.first));
		
		for(int i=0;i<list.size();i++) {
			q.add(new Pair<>(list.get(i).data,list.get(i)));			
		}
		
		
		while(!q.isEmpty()) {
			Pair<Integer,Node> pair = q.poll();
			tempDummyNode.next = pair.second;
			tempDummyNode = tempDummyNode.next;
			
			if(pair.second.next !=null) {
				q.add(new Pair<>(pair.second.next.data,pair.second.next));
			}
			
		}
		
		return dummyNode.next;
	}
}
