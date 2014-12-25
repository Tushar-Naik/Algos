package com.yahoo.algos;

public class Union {
	int [] tree = {3,1,4,1,1,5,5};

	/**
	 * @param args
	 */
	public int root(int i){
		if (tree[i]!=i){
			return root(tree[i]);
		}else{
			return i;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("AUM");
		System.out.println(new Union().root(6));
	}

}
