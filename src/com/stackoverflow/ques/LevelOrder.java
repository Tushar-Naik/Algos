package com.stackoverflow.ques;

import com.yahoo.algos.MyQueue;
import com.yahoo.algos.TreeNode;

public class LevelOrder<T> {

	/**
	 * @param args
	 */
	private class QNode<T>{
		TreeNode<T> node;
		int horizontalDist;
		public QNode(TreeNode<T> node, int hd){
			this.node = node;
			this.horizontalDist = hd;
		}
		public TreeNode<T> getNode() {
			return node;
		}
		public int getHorizontalDist() {
			return horizontalDist;
		}
	}

	MyQueue<QNode<T>> queue = new MyQueue<QNode<T>>(50);
	
	private void bfs(){
		int level ;
		int myLevel =0;
		while(!queue.isEmpty()){
			//Visit node
			QNode<T> qNode =  queue.dequeue();
			TreeNode<T> node = qNode.getNode();
			level = qNode.getHorizontalDist();
			if(level>myLevel){
				myLevel=level;System.out.println();
			}
			System.out.print(node+" ");
			
			//Enqueue child Add if visited check/list for cycle/graph
			if(node.getLeft()!=null) queue.enqueue(new QNode<T>(node.getLeft(), level+1));
			if(node.getRight()!=null) queue.enqueue(new QNode<T>(node.getRight(), level+1));
			
		}
	}
	public void printTree(TreeNode<T> root) {
		queue.enqueue(new QNode<T>(root, 0));
		bfs();
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
		*  
		*  Print 0
		*        5 6  
		*        3 4 7 8
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
		
		new LevelOrder<Integer>().printTree(root);
	}
}
