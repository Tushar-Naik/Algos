package com.yahoo.algos;

public class PathToReachNStairs {

	/**
	 * Given n stairs , you climb 1 , 2 or 3 stairs at a time . Find the number of ways to reach the nth step
	 */
	static int count;
	private void moveup(int stairsNum, int N, String path){
		if(stairsNum>N) return;
		if(stairsNum==N){
			System.out.println(path);count++;
			return;
		}
		
		for(int i=1;i<=3;i++){
			if(i+stairsNum<=N){
				moveup(stairsNum+i, N, path+"-"+i); //(stairsNum+i));
			}
		}
	}
	public static void main(String[] args) {
		new PathToReachNStairs().moveup(0, 6, "");
		System.out.println(count+"ways");
	}
}
