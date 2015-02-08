package com.fb.graph;

import com.yahoo.algos.TreeNode;

public class StructurallySimilarTree {

	/**
	 * @param args
	 */
	
	public boolean isStructurallySimilar(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if(root1==null && root2 == null) return true;
		
		if( (root1.getLeft()!=null && root2.getLeft()==null)  ||
			(root1.getLeft()==null && root2.getLeft()!=null)  ||
			(root1.getRight()!=null && root2.getRight()==null)  ||
			(root1.getRight()==null && root2.getRight()!=null)  ){
			return false;
		}
		
		return isStructurallySimilar(root1.getLeft(), root2.getLeft()) && isStructurallySimilar(root1.getRight(), root2.getRight());	 
	}
	
	public static void main(String[] args) {
		/*
		 *             1        
		 *          /    \
		 *        2        3
		 *         \       / \ 
		 *          4     5   6
		 *           \  
		 *            7
		 *         
		 *             8
		 *          /    \
		 *        9        10
		 *         \       / \ 
		 *          11    12  13
		 *           \  
		 *            14
		*/
		
		TreeNode<Integer> root1 = new TreeNode<Integer>(1); 
		TreeNode<Integer> two = new TreeNode<Integer>(2); 
		TreeNode<Integer> three = new TreeNode<Integer>(3); 
		TreeNode<Integer> four = new TreeNode<Integer>(4); 
		TreeNode<Integer> five = new TreeNode<Integer>(5); 
		TreeNode<Integer> six = new TreeNode<Integer>(6); 
		TreeNode<Integer> seven = new TreeNode<Integer>(7); 
		
		TreeNode<Integer> root2 = new TreeNode<Integer>(8); 
		TreeNode<Integer> nine = new TreeNode<Integer>(9); 
		TreeNode<Integer> ten = new TreeNode<Integer>(10); 
		TreeNode<Integer> eleven = new TreeNode<Integer>(11); 
		TreeNode<Integer> twelve = new TreeNode<Integer>(12); 
		TreeNode<Integer> thirteen = new TreeNode<Integer>(13); 
		TreeNode<Integer> fourteen = new TreeNode<Integer>(14); 
		
		
		root1.setLeft(two);root1.setRight(three);
		two.setRight(four);//four.setRight(seven);
		three.setLeft(five);three.setRight(six);

		root2.setLeft(nine);root2.setRight(ten);
		nine.setRight(eleven);eleven.setRight(fourteen);
		ten.setLeft(twelve);ten.setRight(thirteen);		
		
		System.out.println(new StructurallySimilarTree().isStructurallySimilar(root1, root2));
	}

}
