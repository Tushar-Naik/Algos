package com.fb.graph;

import java.util.ArrayList;

import com.yahoo.algos.TreeNode;

/*
 * Find paths ina tree that sum to x. Note not necessarily a path starting from root
 */
public class FindPaths {

	void findSum(TreeNode<Integer> node, int sum, ArrayList<Integer> buffer,  int level) {
		if(node==null) return;
		buffer.add(node.getKey());
		//verify paths if they matched
		int tmp = sum;
		for(int i = level; i>=0;i--){ // reverse from level to up to make sure it doesnt necessarily go to root
			tmp-=buffer.get(i);
			if(tmp==0) print(buffer, i, level);	 // Doesnt break so that there could be negative vals
		}
		
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		findSum(node.getLeft(), sum, c1, level+1);
		findSum(node.getRight(), sum, c2, level+1);
	}
		
	void print(ArrayList<Integer> buffer, int level, int i2) { 
		
		for (int i = level; i <= i2; i++) {
			System.out.print(buffer.get(i) +" "); 
		}
		System.out.println(); 
	}
	
	void findSum2(TreeNode<Integer> node, int sum, ArrayList<Integer> buffer){
		if(node==null) return;
		buffer.add(node.getKey());
		
		int tmp=0;
		for(int i=buffer.size()-1; i>=0;i--){
			tmp+=buffer.get(i);
			if(tmp==sum){
				print(buffer, i, buffer.size()-1);
			}
			
			
		}
		findSum2(node.getLeft(), sum,  (ArrayList<Integer>)buffer.clone());
		findSum2(node.getRight(), sum, (ArrayList<Integer>) buffer.clone());
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
		
		
		FindPaths tree = new FindPaths();
		tree.findSum(root, 70, new ArrayList<Integer>(), 0);
		//tree.findSum2(root, 70, new ArrayList<Integer>());
	}

}
