package com.flipkart.programs;

public class MyHashMap<Key,Value> {
	private final Node<Key, Value>[] array;
	private static final int CAPACITY = 10;
	
	public MyHashMap(){
		array = new Node[CAPACITY];
	}
	public void put (Key key, Value val){
		int hash = (key.hashCode() & 0x7fffffff)  % CAPACITY; // Making key positive just in case someone gave -ve number
		for(Node<Key, Value> n = array[hash];n!=null;n = n.next){
			if(n.getKey().equals(key)) n.setVal(val);
		}
		array[hash] = new Node<Key, Value>(val,key,array[hash]);
		
	}
	public Value get (Key key){
		int hash = (key.hashCode() & 0x7fffffff) % CAPACITY;
		for(Node<Key,Value> n = array[hash];n!=null;n=n.next){
			if(n.getKey().equals(key)) return n.getVal();
		}
		return null;
	}
	public static void main(String[] args) {
		MyHashMap<Integer,String> map = new MyHashMap<Integer, String>();
		map.put(40,"AUM");
		map.put(10, "ONE");
		System.out.println(map.get(40));
	}
	
	private static class Node<Key, Value>{
		Node<Key, Value> next;
		Value val;
		Key key;
		
		public Node(Value val,Key key,  Node<Key, Value> next){
			this.val = val;
			this.key = key;
			this.next = next;
		}
		public Value getVal() {
			return val;
		}
		public Key getKey() {
			return key;
		}
		public void setVal(Value val) {
			this.val = val;
		}
	}
}

