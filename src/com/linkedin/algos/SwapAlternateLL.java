package com.linkedin.algos;

public class SwapAlternateLL {

	/**
	 * @param args
	 */
	private void swap(Node<String> head){
		Node<String> prev = head;
		Node<String> cur = prev.next;
		head = cur;
		while(true){
			Node<String> next = cur.next;
			cur.next = prev;
			if(next==null || next.next==null){
				prev.next = next; break;
			}
			prev.next = next.next;
			prev= next;
			cur=prev.next;
		}
		Node.printLL(head);
	}
	public static void main(String[] args) {   
		Node<String> first = new Node<String>("a");
	    Node<String> second = new Node<String>("b");
	    Node<String> third = new Node<String>("c");
	    Node<String> fourth = new Node<String>("d");
	    Node<String> fifth = new Node<String>("e");
	    Node<String> sixth = new Node<String>("f");
	    Node<String> seventh = new Node<String>("g");
	    Node<String> eight = new Node<String>("h");
	    Node<String> nine = new Node<String>("i");
	
	    first.setNext(second);
	    second.setNext(third);
	    third.setNext(fourth);
	    fourth.setNext(fifth);
	    fifth.setNext(sixth);
	    sixth.setNext(seventh);
	    seventh.setNext(eight);
	    eight.setNext(nine);
	    
	    Node.printLL(first);
	    
	    new SwapAlternateLL().swap(first);
    }

}
