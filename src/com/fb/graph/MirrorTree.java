package com.fb.graph;

import com.stackoverflow.ques.LevelOrder;
import com.yahoo.algos.TreeNode;

public class MirrorTree <T> {

	/**
	 * @param args
	 */
	public static <T> void mirror(TreeNode<T> node, TreeNode<T> mirrorNode){
		if(node==null|| (node.getLeft() ==null && node.getRight() == null)) return;

		if(node.getLeft()!= null){
			TreeNode<T> left = node.getLeft();
			TreeNode<T> mirrorRight = new TreeNode<T>(left.getKey());
			mirrorNode.setRight(mirrorRight);
			mirror(left, mirrorNode.getRight());
		}

		if(node.getRight()!=null){
			TreeNode<T> right = node.getRight();
			TreeNode<T> mirrorLeft  = new TreeNode<T>(right.getKey());
			mirrorNode.setLeft(mirrorLeft);
			mirror(right, mirrorNode.getLeft());
		}
	}
	public static void main(String[] args) {
		/*
		 *             0
		 *          /    \
		 *        5        6
		 *      /  \       / \ 
		 *    3     4     7   8
		 *   / \    /\   /\    /\
		 *  9  10 11 12 13 14 15 16
		*/
		
		TreeNode<Integer> root = new TreeNode<Integer>(0); 
		TreeNode<Integer> five = new TreeNode<Integer>(5); 
		TreeNode<Integer> six = new TreeNode<Integer>(6); 
		TreeNode<Integer> three = new TreeNode<Integer>(3); 
		TreeNode<Integer> four = new TreeNode<Integer>(4); 
		TreeNode<Integer> seven = new TreeNode<Integer>(7); 
		TreeNode<Integer> eight = new TreeNode<Integer>(8); 
		TreeNode<Integer> nine = new TreeNode<Integer>(9); 
		TreeNode<Integer> ten = new TreeNode<Integer>(10); 
		TreeNode<Integer> eleven = new TreeNode<Integer>(11); 
		TreeNode<Integer> twelve = new TreeNode<Integer>(12); 
		TreeNode<Integer> thirteen = new TreeNode<Integer>(13); 
		TreeNode<Integer> fourteen = new TreeNode<Integer>(14); 
		TreeNode<Integer> fifteen = new TreeNode<Integer>(15); 
		TreeNode<Integer> sixteen = new TreeNode<Integer>(16); 
		
		
		root.setLeft(five);root.setRight(six);
		five.setLeft(three);five.setRight(four);
		three.setLeft(nine);three.setRight(ten);
		four.setLeft(eleven);four.setRight(twelve);
		
		six.setLeft(seven);six.setRight(eight);
		seven.setLeft(thirteen);seven.setRight(fourteen);
		eight.setLeft(fifteen);eight.setRight(sixteen);
		
		TreeNode<Integer> mirrorNode = new TreeNode<Integer>(root.getKey());
		new MirrorTree<Integer>().mirror(root, mirrorNode);
		LevelOrder<Integer> level = new LevelOrder<Integer>();
		level.printTree(mirrorNode);
	}

}
