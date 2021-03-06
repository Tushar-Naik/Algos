package com.linkedin.algos;

public class FindLoopLL<T> {

        public void findLoop(Node<T> node){
                Node<T> slow = node ;
                Node<T> fast= node ;
                while(fast!=null & fast.next!= null && fast.next.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow){
                            System.out.println("Cycle detected");
                            removeLoop(node, slow);
                            return;
                    }
                }
                System.out.println("No Cycle detected");

        }
        
        public void removeLoop(Node<T> node, Node<T> slow){
        	//Find the nodes in loop
        	Node<T> start = slow.next();
        	int k =1;
        	while(start!=slow){
        		start = start.next;k++;
        	}
        	//Move k points from head
        	start = node;
        	for(int i=0;i<k;i++){
        		start = start.next;
        	}
        	//move one pointer from start and other from head. 
        	Node<T> head = node; 
        	Node<T> tmp=head ;
        	while(head!=start){
        		tmp = start;
        		head= head.next;
        		start=start.next;
        	}
        	
        	System.out.println("Loop point at "+ start);
        	tmp.next=null;
        	Node.printLL(node);
        }
        
        

        public static void main(String[] args) {
                Node<Integer> first = new Node<Integer>(1);
                Node<Integer> second = new Node<Integer>(2);
                Node<Integer> third = new Node<Integer>(3);
                Node<Integer> fourth = new Node<Integer>(4);
                Node<Integer> fifth = new Node<Integer>(5);

                first.setNext(second);
                second.setNext(third);
                third.setNext(fourth);
                fourth.setNext(second);
//                fifth.setNext(third);
                Node.printLL(first);
//
//              Node.printLL(fourth);
                new FindLoopLL<Integer>().findLoop(first);
        }
}

