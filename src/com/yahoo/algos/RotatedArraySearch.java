package com.yahoo.algos;

public class RotatedArraySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] arr = {8,9,10,1,2,3,4,5,6,7};
		int[] arr = {2,3,2,2,2};
		int searchFor = 3;
		System.out.println(searchRotated(arr, 0, arr.length-1, searchFor ));
	}

	private static int searchRotated(int[] arr, int low, int high, int searchFor) {

		if( low > high) {
			return -1;
		}
		int mid = low+ (high - low)/2;
		
		if(arr[mid]==searchFor)
			return mid;
		
		// right array is sorted
		if(arr[mid] <= arr[high] ){ 
			if (searchFor >= arr[mid] && searchFor <= arr[high]){
				low = mid+1;
			}else{
				high = mid-1;
			}
			
		}else if (arr[low]<=arr[mid]) { //Right array is sorted
			if(searchFor<=arr[mid] && searchFor >= arr[low]){
				high = mid -1;
			}else {
				low = mid+1;
			}
		}
		//For Duplicate elements
		/*else if(arr[mid]==arr[low]){
			if(arr[mid]==arr[high]){
				low = mid+1;
			}else{
				//Need to search both sides
				int ret = searchRotated(arr, low, mid-1, searchFor);
				if(ret==-1){
					return searchRotated(arr, mid+1, high, searchFor);
				}else return ret;
			}
		}
		*/
		return searchRotated(arr, low, high, searchFor);
	}

}
