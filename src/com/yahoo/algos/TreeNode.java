package com.yahoo.algos;

public class TreeNode<T> {
	T key;
	TreeNode<T> left,right;
	int depth;
	int pathSize;

	public TreeNode(T key) {
		this.key = key;
	}
	
	public void setLeft(TreeNode<T> node){
		this.left = node;
	}
	public void setRight(TreeNode<T> node){
		this.right = node;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	
	public int getDepth() {
		return depth;
	}
	public int getPathSize() {
		return pathSize;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setPathSize(int pathSize) {
		this.pathSize = pathSize;
	}
	public T getKey() {
		return key;
	}
	
	@Override
	public String toString(){
		return key.toString();
	}
}
