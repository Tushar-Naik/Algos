package com.flipkart.programs;

import java.util.HashMap;

public class LRUCache<K,V> {

	/**
	 * Linkedlist + Hashmap
	 *
	 * 
	 * Things to remember 
	 * (a) Hashmap is Map<K, Node<K,V>>  and we maintain head/tail for double linked list
	 * (b) Node has the Value and key both. K needed for step (2)
	 * (c) PUT: when we reach capacity we need to remove from map. Now we need key to remove get that from Node and hence Node has K  
	 * (d) GET: to maintain access order or the fetched item has to go to head of queue make sure both prev/next of a node are corrected.
	 *          Fetch puts node fetched on head. two use cases one when node removed is tail one when its mid, nothing for head
	 */
	private Node<V, K> head, tail ;
	private HashMap<K,Node<V,K>> map = new HashMap<K,Node<V,K>>();
	private static final int CAPACTITY = 3;
	private int currentSize = 0;
	
	private static class Node<V, K>{
		Node<V,K> next;
		Node<V,K> prev;
		V val;
		K key;
		public Node(Node<V, K> prev, Node<V,K> next, V val, K key) {
			this.prev = prev;
			this.next = next;
			this.val = val;
			this.key = key;
		}
		public V getVal() {
			return val;
		}
		public K getKey() {
			return key;
		}
		
		@Override
		public String toString() {
			return val.toString();
		}
	}
	
	public void put(K key, V val){
		Node<V,K> node = addToLinkedList(val, key);
		map.put(key, node);
		
	}
	
	private Node<V,K> addToLinkedList(V val, K key) {
		if (head==null){
			Node<V,K> newNode = new Node<V,K>(null, null, val, key) ;
			head = newNode; tail = newNode;
			currentSize++;
			
		}else {
			//Capacity check delete the oldest
			if(currentSize==CAPACTITY){
				Node<V,K> tmp = tail;
				map.remove(tail.getKey());
				tail.next.prev = null;
				tail = tail.next;
				tmp = null; currentSize--;
			}
			Node<V,K> newNode = new Node<V,K>(head, null, val , key) ;
			head.next = newNode;
			head = newNode;
			currentSize++;
		}
		return head;
	}

	public V get(K key){
		iterate();
		Node<V,K> node = map.get(key);
		if(tail==node){
			Node<V,K> next = node.next;
			next.prev = null;
			tail = next;
			node.next = null;
			node.prev = head;
			head.next = node;
			head = node;
			
		} else if (head != node){
			
			Node<V,K> prev = node.prev;
			Node<V,K> next = node.next;
			prev.next = next;
			next.prev = prev;
			node.next = null;
			node.prev = head;
			head.next = node;
			head = node;
		}
		iterate();
		return map.get(key).getVal();
	}
	
	public void iterate(){
		for(Node<V,K> node = tail;node!=null; node  = node.next){
			System.out.print(node.getKey()+"-"+node.getVal()+"  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache = new LRUCache<Integer, String>();
		lruCache.put(1,"A");
		lruCache.put(2,"B");
		lruCache.put(3,"C");
		lruCache.iterate();
		lruCache.put(4,"D");
		lruCache.iterate();
		lruCache.get(2);
	}

	
}