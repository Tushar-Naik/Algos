package com.linkedin.algos;

import com.stackoverflow.ques.LevelOrder;
import com.yahoo.algos.TreeNode;

public class CreateDLListFromTree{

	/**
	 * Important learning here. See when you go left and right of tree by recursive call like call(node.left) 
	 * you can always return from call stack at leaf same can be assigned back like node.left = call(node.getleft)
	 */
	
	private static TreeNode head, tail;
	private TreeNode createDoubleLL(TreeNode node){
		if(node==null) return null;
	
		//If leaf add to DLL adjust pointers
		if(node.getLeft()==null && node.getRight()==null){
			if(head!=null){
				tail.setRight(node); node.setLeft(tail);tail=node;
			}else {
				head=node;tail=node;
			}
			return null;
		}
		node.setLeft(createDoubleLL(node.getLeft()));
		node.setRight(createDoubleLL(node.getRight()));

		return node;	
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
		
		CreateDLListFromTree tree = new CreateDLListFromTree();
		tree.createDoubleLL(root);
		new LevelOrder<Integer>().printTree(root);
		
		System.out.print("\nDLL: ");
		TreeNode cur = head;
		while(cur!=null){
			System.out.print(cur.getKey()+"<->");
			cur=cur.getRight();
		}
	}

}
