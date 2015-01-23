
package com.fb.graph;
import com.yahoo.algos.TreeNode;

public class OrgHistory<T> {

	/**
	 * @param args
	 */
	private void print(TreeNode<Integer> node) {
		if(node==null)
			return;
		
		if(node.getLeft() == null && node.getRight()==null ){
			return;
		}
		
		if (node.getLeft()!=null){
			System.out.println(node.getKey() +" manages "+ node.getLeft().getKey());
		}
		if (node.getRight()!=null){
			System.out.println(node.getKey() +" manages "+ node.getRight().getKey());
		}
		
		print(node.getLeft());
		print(node.getRight());
		
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
		
		
		OrgHistory<Integer> tree = new OrgHistory<Integer>();
		System.out.println( "\nPRE ORDERR");tree.print(root);
	
	}



}
