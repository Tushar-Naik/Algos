package com.stackoverflow.ques;

public class BSTNode<K,V> {
	 K key;
	 V value;
	 BSTNode<K,V> left, right;
	
	public BSTNode(K key, V value){
		this.key = key;
		this.value = value;
	}
	public BSTNode(BSTNode<K,V> left, BSTNode<K,V> right){
		this.left = left;
		this.right = right;
	}
}
