package com.yahoo.algos;

/*
 * Note max sum in such case wher alternate is to be selected is always
 * sum[i] = (include current element + last but one's sum ) or last sum (dont include current)
 */
public class NoAdjecentMaxSum {

	private void maxSum(final int[] array){
		int sum[] = new int[array.length];
		sum[0]=array[0];
		sum[1]=Math.max(array[0], array[1]);
		for(int i = 2;i<=array.length-1; i++){
			sum[i]= Math.max(array[i] + sum[i-2], sum[i-1]);  //Note just this
		}
		
		for(int i =0;i<=array.length-1; i++){
			System.out.println(String.format("a[%d]=%d",i,sum[i]));
		}
		System.out.println("----- Max Sum:"+sum[array.length-1]);
		
	}
	public static void main(String[] args) {
		//int[] array = new int[]{3,2,5,10,7};
		//int[] array = new int[]{5,5,10,40,50,35};
		int[] array = new int[]{1,2,0,40,0,5,40,6};
		new NoAdjecentMaxSum().maxSum(array);
	}

}
