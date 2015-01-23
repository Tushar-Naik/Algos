package com.fb.graph;

import com.yahoo.algos.TreeNode;

public class ConvertChildrenSum<T> {

	/**
	 * ChildrenSumProp
	 * For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children
	 */
	
	private void convert(TreeNode<Integer> node) {
		if(node == null ) return;
		convert(node.getLeft());
		convert(node.getRight());
		
		int lval =  (node.getLeft()!=null)? node.getLeft().getKey() : 0;
		int rval =  (node.getRight()!=null)? node.getRight().getKey() : 0;
		
		if( lval+rval !=0)
			node.setKey(lval+rval);
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
		
		
		ConvertChildrenSum<Integer> tree = new ConvertChildrenSum<Integer>();
		InOrderTraversal<Integer> order = new InOrderTraversal<Integer>();
		order.inOrder(root);
		
		System.out.println( "\nPRE ORDERR");tree.convert(root);
	
		order = new InOrderTraversal<Integer>();
		order.inOrder(root);
	}

	

}
