package com.stackoverflow.ques;

public class BST <K extends Comparable<K>, V> {
    
    private class Node{
        K key;
        V value;
        Node left; 
        Node right;
		public int size;
        
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public Node insert(Node node,  K key, V value){
        if(node==null) 
            return new Node(key,value);
        
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
            node.right = insert(node.right, key, value);
        }else if(cmp < 0){
            node.left = insert(node.left, key, value);
        }else{
            node.value = value;
        }
        node.size = 1+ size(node.left) + size(node.right);
        return node;    
    }
    
    public V search(Node node, K key){
        if(node == null) return null;

        while(node!=null){
            int cmp = key.compareTo(node.key);
            if(cmp > 0 ){
                node = node.right;
            }else if (cmp<0){
                node = node.left;
            }else {
                return (V)node.value;
            }            
        }
        return null;
    }
    
    
    /* Greatest number lesser than the number given*/
    public Node floor(Node node, K key){
        if(node==null) 
            return null;
        
        int cmp = key.compareTo(node.key);
        if(cmp < 0 ){
            return floor(node.left, key );
        }else if (cmp==0)
            return node;
        else {
            Node t = floor(node.right, key);
            if(t==null) return node;
            else return t;
        }     
    }
    /* Root node as input 
    *   
    */
    public Node delete(K key, Node node){
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp>0){
            delete(key, node.right);
        }else if(cmp<0){
            delete(key, node.left);
        }else {
            if(node.right==null) return node.left;
            Node t = node;
            node = getMin(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
         }
       node.size = 1+ size(node.left) + size(node.right);
       return node;
    }
    
    private Node getMin(Node node) {
		if(node.left==null) return node;
		return getMin(node.left);
	}

	private Node deleteMin(Node node){
        if(node.left==null) return node.right;
        node.left =  deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }
    
    
    private int size(Node node){
        if(node==null) return 0;
        else return node.size;
    }

    public int search(int searchFor, int low, int high, int[] array){
        while(low<=high){
            int mid = low + (high-low)/2;
            if (searchFor > array[mid]){
                low = mid+1;
           }else if (searchFor > array[mid]){
                high = mid -1;
           }else return array[mid];         
        }
        return -1;     
    }
    
    
    public static void main (String args[]){
    }
}