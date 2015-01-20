package com.fb.graph;

/*
 * http://www.geeksforgeeks.org/618/
 * DFS types Pre/post/in order traversal
 * pre: To take copy of tree.  sorted order. Polix notation
 * POST: To delete the tree.
 */
import com.yahoo.algos.TreeNode;

public class InOrderTraversal<T>{

	public void inOrder(TreeNode<T> node){
		if(node==null) return;
		inOrder(node.getLeft());
		System.out.print(node+" ");
		inOrder(node.getRight());
	}
	
	private void preOrder(TreeNode<T> node){
		if(node==null) return;
		System.out.print(node+" ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}
	
	private void postOrder(TreeNode<T> node){
		if(node==null) return;
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node+" ");
	}
	
	public void descOrder(TreeNode<T> node){
		if (node==null) return;
		descOrder(node.getRight());
		System.out.print(node+" ");
		descOrder(node.getLeft());
	}

	
	public static void main(String[] args) {
		/*
		 *             50
		 *          /    \
		 *        30       70
		 *      /  \      / 
		 *    20     40  60  
		*/
		
		TreeNode<Integer> root = new TreeNode<Integer>(50); 
		TreeNode<Integer> thirty = new TreeNode<Integer>(30); 
		TreeNode<Integer> seventy = new TreeNode<Integer>(70); 
		TreeNode<Integer> twenty = new TreeNode<Integer>(20); 
		TreeNode<Integer> fourty = new TreeNode<Integer>(40); 
		TreeNode<Integer> sixty = new TreeNode<Integer>(60); 
		
		root.setLeft(thirty);root.setRight(seventy);
		thirty.setLeft(twenty);thirty.setRight(fourty);
		seventy.setLeft(sixty);
		
		
		InOrderTraversal<Integer> tree = new InOrderTraversal<Integer>();
		System.out.println( "\nIN ORDER");tree.inOrder(root);
		System.out.println( "\nPOST ORDER");tree.postOrder(root);
		System.out.println( "\nPRE ORDERR");tree.preOrder(root);
	
	}
}
