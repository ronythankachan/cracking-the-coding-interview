package datastructures;

public class BST {
	Node root;
	
	BST(){
		root = null;
	}
	
	void inorder(Node root) {
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);
	}
	
	void preorder(Node root) {
		if(root == null) return;
		System.out.println(root.value);
		preorder(root.left);
		preorder(root.right);
	}
	
	void postorder(Node root) {
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.value);
	}
	
	Node insert(Node root,int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		else if(root.value<value) root.left = insert(root.left,value);
		else root.right = insert(root.right,value);
		return root;
	}

	Node search(Node root,int value) {
		if(root.value == value || root==null) return root;
		else if(root.value<value) return search(root.left,value);
		else return search(root.right,value);
	}
	
	public static void main(String[] args) {
		BST tree = new BST();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(15);
		tree.insert(tree.root, 13);
//		tree.inorder(tree.root);
		tree.preorder(tree.root);
//		tree.postorder(tree.root);
	}
}
class Node{
	int value;
	Node left,right;
	Node(int value){
		this.value = value;
		this.left = this.right = null;
	}
}

