package com.fb.graph;

import com.yahoo.algos.TreeNode;

public class BinaryTreeBalanced<T> {

	/**
	 * @param args
	 */
	private boolean isBalanced(TreeNode<Integer> node) {
		if(node==null)
			return true;
		
		if ( (node.getLeft() == null && node.getRight()!=null ) || 
		     (node.getLeft() != null && node.getRight()==null )	){
			return false;
		}
		
		return isBalanced(node.getLeft()) &&  isBalanced(node.getRight());
		
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
		//TreeNode<Integer> sixty = new TreeNode<Integer>(60); 
		
		root.setLeft(thirty);root.setRight(seventy);
		thirty.setLeft(twenty);thirty.setRight(fourty);
		//seventy.setLeft(sixty);
		
		
		BinaryTreeBalanced<Integer> tree = new BinaryTreeBalanced<Integer>();
		System.out.println( "\nIS BALANCED: "+tree.isBalanced(root));
	
	}



}
