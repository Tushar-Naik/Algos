package com.fb.graph;

import com.stackoverflow.ques.LevelOrder;
import com.yahoo.algos.TreeNode;

public class ReverseTheTree {

	/**
	 * Node has only one right child which is leaf and now reverse the tree
	 *			1
	 *		  /   \
	 *       2		3
	 *      / \
	 *    4    5
	 *   / \
	 *  6   7
	 *  
	 *  to
	 *  
	 *             6
	 *            / \
	 *          7    4
	 *              / \
	 *             5   2	
	 *                / \
	 *               3   1
	 * @param root 
	 */
	
	private TreeNode<Integer> reverse(TreeNode<Integer> node, int level){
		if(node.getLeft()==null) return node;
		
		TreeNode<Integer> xNode = reverse(node.getLeft(), level+1);
		xNode.setLeft(node.getRight());
		xNode.setRight(node);
		if(level==0){
			node.setLeft(null);node.setRight(null);return node;
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		/*
		 *			1
		 *		  /   \
		 *       2		3
		 *      / \
		 *    4    5
		 *   / \
		 *  6   7
		*/
		
		TreeNode<Integer> root = new TreeNode<Integer>(1); 
		TreeNode<Integer>  two = new TreeNode<Integer>(2); 
		TreeNode<Integer> three = new TreeNode<Integer>(3); 
		TreeNode<Integer> four = new TreeNode<Integer>(4); 
		TreeNode<Integer> five = new TreeNode<Integer>(5); 
		TreeNode<Integer> six = new TreeNode<Integer>(6); 
		TreeNode<Integer> seven = new TreeNode<Integer>(7); 
		
		root.setLeft(two);root.setRight(three);
		two.setLeft(four);two.setRight(five);
		four.setLeft(six);four.setRight(seven);
		
		ReverseTheTree tree = new ReverseTheTree();
		new LevelOrder<Integer>().printTree(root);
		tree.reverse(root, 0);
		System.out.println("\nReversed Tree:");
		new LevelOrder<Integer>().printTree(six);
	}
}
