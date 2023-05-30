package tree;


public class BST {

	Node root;
	
	BST(){
		root = null;
	}
	
	
	void add(int data) {
		
		root = addRecusive(root,data);
	}


	public Node addRecusive(Node root, int data) {
	
		Node tmp = new Node(data);
		
		if(root == null) return root = tmp;
		
		if(data > root.data) {
			root.right = addRecusive(root.right,data);
		}else {
			root.left = addRecusive(root.left,data);;
		}
		
		return root;
	}
	
	public void inorder(Node root) {
		if(root == null) return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	
}
