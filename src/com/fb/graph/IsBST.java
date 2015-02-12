package com.fb.graph;

import com.yahoo.algos.TreeNode;

public class IsBST {

	/**
	 * @param args
	 */
	// METHOD 1 (Simple but Wrong) what about each subtree they should be BST as well
	private boolean isBST(TreeNode<Integer> node){
		if(node==null)
			return true;
		
		if(node.getLeft()!=null && (node.getKey() < node.getLeft().getKey()) ||
		   node.getRight()!=null && (node.getKey() > node.getRight().getKey())	){
			return false;
		}
		
		return isBST(node.getLeft()) && isBST(node.getRight());
	}
	
	/* Traverse inorder */
	static TreeNode<Integer> prev = null;
	private boolean isBSTNew(TreeNode<Integer> node){
		if(node==null) return true;
		
		if(!isBSTNew(node.getLeft())){
			return false;
		}
		
		if(prev!=null && prev.getKey() > node.getKey()){
			return false;
		}
		prev = node;
		
		if(!isBSTNew(node.getRight())){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		/*
		 *             50
		 *          /    \
		 *        30       70
		 *      /  \      / 
		 *    20     40  60  
		 *      \
		 *       31 
		*/
		
		TreeNode<Integer> root = new TreeNode<Integer>(50); 
		TreeNode<Integer> thirty = new TreeNode<Integer>(30); 
		TreeNode<Integer> seventy = new TreeNode<Integer>(70); 
		TreeNode<Integer> twenty = new TreeNode<Integer>(20); 
		TreeNode<Integer> fourty = new TreeNode<Integer>(40); 
		TreeNode<Integer> sixty = new TreeNode<Integer>(60); 
		TreeNode<Integer> eighty = new TreeNode<Integer>(31); 
		
		root.setLeft(thirty);root.setRight(seventy);
		thirty.setLeft(twenty);thirty.setRight(fourty);
		seventy.setLeft(sixty);
		twenty.setRight(eighty);
		
		IsBST tree = new IsBST();
		System.out.println( "\nIS BALANCED: "+tree.isBST(root));
		System.out.println( "\nIS BALANCED: "+tree.isBSTNew(root));

	
	}

}
