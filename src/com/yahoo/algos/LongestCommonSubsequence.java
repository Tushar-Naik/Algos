package com.yahoo.algos;

public class LongestCommonSubsequence {

	/**
	 * LongestCommonSubsequence 
	 * AGGTAB  and
	 * GXTXAYB
	 * has GTAB as common. The subsequence can be not consecutive
	 * 
	 */
	private void lcs(char[]x, char[] y){
		int m = x.length;
		int n = y.length;
		int[][] common = new int[m][n];
		for(int i =0;i<m;i++){
			for( int j = 0;j<n;j++){
				if(i==0 || j==0){
					common[i][j] = 0;
				}else if(x[i-1]==y[j-1]){
					common[i][j]= 1 + common[i-1][j-1];
				}else if(x[i-1]!=y[j-1]){
					common[i][j]= Math.max(common[i-1][j], common[i][j-1]);
				}
			}
		}
		System.out.println("Total size of LCS is: "+common[m-1][n-1]);
		
		//now lets print it. Note the way matrix common was created is you move down or right when a match is found
		char[] lcs = new char[common[m-1][n-1]+1];
		int index=lcs.length-1;
		int i=m; int j=n;
		while(i>0 && j>0){
			if(x[i-1]==y[j-1]){
				lcs[index] = x[i-1];
				i--;j--;index--;
			}else if(common[i-1][j] > common[i][j-1]){       
				i--;
			}else{
				j--;
			}
		}
		
		for(int k=0;k<lcs.length;k++){
			System.out.print(lcs[k]);
		}
	}
	
	public static void main(String[] args) {
		new LongestCommonSubsequence().lcs("AGGTAB".toCharArray(), "GXTXAYB".toCharArray());
	}

}
