package com.linkedin.algos;

public class PalindromeLL<T> {

	Node<T> last ;
	/**
	 * Go to center
	 */
	private void isPalindrome(Node<T> first) {
		//Reach center of the LL
		Node<T> fast = first;
		Node<T> slow = first;
		int count =0;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			count ++;
		}
		System.out.println("Mid point: "+slow);
		new ReverseLinkedList<T>().reverse(slow.next);
		slow.next = null;
		
		Node.printLL(first);
		Node.printLL(last);
		
		
		
	}

	public static void main(String[] args) {
        Node<String> first = new Node<String>("a");
        Node<String> second = new Node<String>("b");
        Node<String> third = new Node<String>("c");
        Node<String> fourth = new Node<String>("d");
        Node<String> fifth = new Node<String>("c");
        Node<String> sixth = new Node<String>("b");
        Node<String> seventh = new Node<String>("a");

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
        Node.printLL(first);
//
        PalindromeLL<String> pailen =  new PalindromeLL<String>();
        pailen.last = seventh;
        pailen.isPalindrome(first);
	}
}
