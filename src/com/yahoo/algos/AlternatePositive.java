package com.yahoo.algos;

public class AlternatePositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		alternate1();
		System.out.println();
		alternate2();
	}
	private static void alternate2() {//NOt working
		int [] arr = {1, 2, 3, -4, -1, 4};//{-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
		int n = arr.length ;

		Common.print(arr);
		for(int i=0;i<n;i++){
			if( (i%2==0 && arr[i]<0) ||
				(i%2!=0 && arr[i]>0) ){
				continue;
			}
			
			int p,q =i;
		
			for (int j=i+1;j<n;j++){
				if(arr[j]<0){
					q=j+1;
//					reverse(arr, i, j);
				}
			}
			
		}
		
	}
	
	private static void alternate1() {
		int [] arr = {1, 2, 3, -4, -1, 4};//{-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
		Common.print(arr);
		int n = arr.length ;
		for (int i=0;i<n;i++){
			if( (i%2==0) && arr[i]>0   ){
				for (int j=i+1;j<n;j++){
					if(arr[j]<0){
						Common.swap(arr, i, j);break;
					}
				}
			}
			if(  (i%2 !=0)  && arr[i] <0){
				for (int j=i+1;j<n;j++){
					if(arr[j]>0){
						Common.swap(arr, i, j);break;
					}
				}	
			}
		}
		System.out.println("");
		Common.print(arr);
	}
}
