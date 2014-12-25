package com.linkedin.algos;

public class ReverseLinkedList<T> {

        public void reverse(Node<T> node){
                Node<T> main = node;
                Node<T> next = node.next;
                Node<T> next2;
                main.next = null;
                while(next!=null){
                        next2 = next.next;
                        next.setNext(main);
                        main = next;
                        next = next2;
                }
        }

        public static void main(String[] args) {
                Node<Integer> first = new Node<Integer>(1);
                Node<Integer> second = new Node<Integer>(2);
                Node<Integer> third = new Node<Integer>(3);
                Node<Integer> fourth = new Node<Integer>(4);

                first.setNext(second);
                second.setNext(third);
                third.setNext(fourth);
                Node.printLL(first);
                Node.printLL(fourth);
                new ReverseLinkedList<Integer>().reverse(first);
                Node.printLL(fourth);
        }
}