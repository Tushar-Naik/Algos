package com.stackoverflow.ques;

import com.yahoo.algos.TreeNode;

public class PrintLeftNodes {

	/**
	 * Print all left nodes of a Tree
	 */
	private void printAllLeftNodes(TreeNode<Integer> node) {
		if(node==null || isLeaf(node))
			return ;
		
		if( node.getLeft()!=null && !isLeaf(node.getLeft())){
			System.out.println(node.getLeft().getKey());
		}
		
		printAllLeftNodes(node.getLeft());
		printAllLeftNodes(node.getRight());
		
	}
	
	private void printAllRightNodes(TreeNode<Integer> node) {
		if(node==null || isLeaf(node))
			return ;
		
		if( node.getRight()!=null && !isLeaf(node.getRight()) ){
			System.out.println(node.getRight().getKey());
		}
		
		printAllRightNodes(node.getLeft());
		printAllRightNodes(node.getRight());
		
	}
	
	private void printAllLeafNodes(TreeNode<Integer> node) {
		if(node==null) return;
		if(isLeaf(node)){
			System.out.println(node.getKey());
		}
		
		printAllLeafNodes(node.getLeft());
		printAllLeafNodes(node.getRight());
	}
	
	private boolean isLeaf(TreeNode<Integer> node){
		//if(node==null) return true;//Shouldnt be called with ideally
		return (node.getLeft()==null && node.getRight()==null);
	}
	
	public static void main(String[] args) {
		/*
		 *             1        
		 *          /    \
		 *        2        3
		 *         \       /  \ 
		 *          4     5    6
		 *           \   /     /
		 *            7 8     11 
		 *               \    /
		 *                9  12
		 *               / 
		 *             10 
		*/
		
		TreeNode<Integer> root = new TreeNode<Integer>(1); 
		TreeNode<Integer> two = new TreeNode<Integer>(2); 
		TreeNode<Integer> three = new TreeNode<Integer>(3); 
		TreeNode<Integer> four = new TreeNode<Integer>(4); 
		TreeNode<Integer> five = new TreeNode<Integer>(5); 
		TreeNode<Integer> six = new TreeNode<Integer>(6); 
		TreeNode<Integer> seven = new TreeNode<Integer>(7); 
		TreeNode<Integer> eight = new TreeNode<Integer>(8); 
		TreeNode<Integer> nine = new TreeNode<Integer>(9); 
		TreeNode<Integer> ten = new TreeNode<Integer>(10); 
		TreeNode<Integer> eleven = new TreeNode<Integer>(11); 
		TreeNode<Integer> twelve = new TreeNode<Integer>(12); 
		
		root.setLeft(two);root.setRight(three);
		two.setRight(four);four.setRight(seven);
		three.setLeft(five);three.setRight(six); six.setLeft(eleven);
		five.setLeft(eight);eight.setRight(nine);
		nine.setLeft(ten);eleven.setLeft(twelve);
		
		System.out.println("Left:");new PrintLeftNodes().printAllLeftNodes(root);
		System.out.println("Right :");new PrintLeftNodes().printAllRightNodes(root);
		System.out.println("Leaf :");new PrintLeftNodes().printAllLeafNodes(root);

	}
}
