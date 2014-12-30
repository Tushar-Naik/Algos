package com.stackoverflow.ques;

public class BST<K extends Comparable<K>,V> {

	
	public BSTNode<K,V> insert(BSTNode<K,V> x, K key, V value){
		if(x==null){
			return new BSTNode(key, value);
		}
		
		int cmp = key.compareTo(x.key);
		if(cmp > 0){
			x.right = insert(x.right, key, value);
		}else if (cmp < 0){
			x.left = insert(x.left, key, value);	
		}else {
			x.value = value;
		}
		return x;
	}
	
	public V search(BSTNode<K,V> x, K key){
		while(x!=null){
			int cmp = key.compareTo(x.key);
			if(cmp > 0){
				x = x.right;
			}else if (cmp < 0){
				x = x.left;
			}else {
				return x.value;
			}
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
