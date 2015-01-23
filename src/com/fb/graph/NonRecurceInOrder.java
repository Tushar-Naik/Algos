package com.fb.graph;

import com.yahoo.algos.TreeNode;

public class NonRecurceInOrder<T> {
	private void inOrder(TreeNode<Integer> root) {
		TreeNode<Integer> current = root;
		
		while(current!=null){
			if(current.getLeft()== null){
				System.out.print(current+" ");
				current = current.getRight();
			}else{
				//Find the inorder predecessor of current 
				TreeNode<Integer> pre = current.getLeft();
				while(pre.getRight()!=null && pre.getRight()!=current){
					pre = pre.getRight();
				}
				
				// Make current as right child of its inorder predecessor */
				if(pre.getRight()==null){
					pre.setRight(current);
					current = current.getLeft();
				}else{
					pre.setRight(null);
					System.out.print(current+" ");
					current = current.getRight();
				}
			}
		}
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
		
		
		NonRecurceInOrder<Integer> tree = new NonRecurceInOrder<Integer>();
		System.out.println( "\nIN ORDER");tree.inOrder(root);
	
	}

	

}
