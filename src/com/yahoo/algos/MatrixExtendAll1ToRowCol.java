package com.yahoo.algos;

public class MatrixExtendAll1ToRowCol {

	/**
	 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
	 * Given a boolean matrix mat[M][N] of size M X N,
	 *  modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
	 *  
	 *   The matrix
			1 0 0 1
			0 0 1 0
			0 0 0 0
		should be changed to following
			1 1 1 1
			1 1 1 1
			1 0 1 1
	 */
	
	private void convertMatrix(final int[][] matrix){
		int rows = matrix.length ;
		int cols = (rows==0)?0:matrix[0].length;  // nice trick na? i found

		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(matrix[i][j]==1){
					moveAllOneToRowCol(matrix, i , j);
				}
			}
		}
		
		moveAllTwoBackToOne(matrix);
		Common.printMatrix(matrix);
	}
	
	private void moveAllTwoBackToOne(int[][] matrix) {
		int rows = matrix.length ;
		int cols = (rows==0)?0:matrix[0].length;  

		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(matrix[i][j]==2) {matrix[i][j]=1;}
			}
		}
	}

	private void moveAllOneToRowCol(final int[][] matrix, final int rowVal, final int colVal) {
		int rows = matrix.length ;
		int cols = (rows==0)?0:matrix[0].length;
		//mark the complete row where we have 0 to 2
		for(int i=0;i<cols;i++){
			if(matrix[rowVal][i]==0) {matrix[rowVal][i]=2;}
		}
		//mark the complete row where we have 0 to 2
		for(int i=0;i<rows;i++){
			if(matrix[i][colVal]==0) {matrix[i][colVal]=2;}
		}
		Common.printMatrix(matrix);
	}

	public static void main(String[] args) {
//		int[][] matrix = {{0,0,0},{0,0,1}};
		int[][] matrix = {{1,0,0,1},
				 		  {0,0,1,0},
				 		  {0,0,0,0}};
		Common.printMatrix(matrix);
		new MatrixExtendAll1ToRowCol().convertMatrix(matrix);
	}

}
