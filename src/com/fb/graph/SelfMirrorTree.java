package com.fb.graph;

import com.stackoverflow.ques.LevelOrder;
import com.yahoo.algos.TreeNode;

/**
 * Find if a Tree is a self mirror of itself
 */
public class SelfMirrorTree<T> {

	private boolean mirror(TreeNode<String> nodeA, TreeNode<String> nodeB) {
		if(nodeA==null && nodeB==null) {return true;}
		if(nodeA.getKey()!=nodeB.getKey()) { return false;}
		if( (nodeA.getLeft()==null && nodeB.getRight()!=null) || 
				(nodeA.getRight()==null && nodeB.getLeft()!=null) ||
				(nodeB.getRight()==null && nodeA.getLeft()!=null) ||
				(nodeB.getLeft()==null && nodeA.getRight()!=null) ) {
			return false; //Not Symmetrical
		}
		if(nodeA.getLeft()==null && nodeA.getRight()==null && nodeB.getLeft()==null && nodeB.getRight()==null ) {
			return true; //leaf node
		}
		
		return mirror(nodeA.getLeft(), nodeB.getRight()) && mirror(nodeA.getRight(), nodeB.getLeft()) ;
	}
	public static void main(String[] args) {
		/*
		 *               0
		 *          /        \
		 *        5 a         6a
		 *      /  \         /   \ 
		 *    3b     4c     7c    8b
		 *   /     /  \     /\     \
		 *  9d   11e 12f  13f 14e   16d
		*/
		
		TreeNode<String> root = new TreeNode<String>("0"); 
		TreeNode<String> five = new TreeNode<String>("a"); 
		TreeNode<String> six = new TreeNode<String>("a"); 
		TreeNode<String> three = new TreeNode<String>("b"); 
		TreeNode<String> four = new TreeNode<String>("c"); 
		TreeNode<String> seven = new TreeNode<String>("c"); 
		TreeNode<String> eight = new TreeNode<String>("b"); 
		TreeNode<String> nine = new TreeNode<String>("d"); 
		//TreeNode<String> ten = new TreeNode<String>("10"); 
		TreeNode<String> eleven = new TreeNode<String>("e"); 
		TreeNode<String> twelve = new TreeNode<String>("f"); 
		TreeNode<String> thirteen = new TreeNode<String>("f"); 
		TreeNode<String> fourteen = new TreeNode<String>("e"); 
//		TreeNode<String> fifteen = new TreeNode<String>(15); 
		TreeNode<String> sixteen = new TreeNode<String>("d"); 
		
		
		root.setLeft(five);root.setRight(six);
		five.setLeft(three);five.setRight(four);
		three.setLeft(nine);//three.setRight(ten);
		four.setLeft(eleven);four.setRight(twelve);
		
		six.setLeft(seven);six.setRight(eight);
		seven.setLeft(thirteen);seven.setRight(fourteen);
		//eight.setLeft(fifteen);
		eight.setRight(sixteen);
		
		new LevelOrder<String>().printTree(root);
		System.out.println("\n\n"+new SelfMirrorTree<String>().mirror(root.getLeft(), root.getRight()));
	}
}
