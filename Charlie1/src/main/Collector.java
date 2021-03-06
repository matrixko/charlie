package main;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.ArrayList;

public class Collector {

	/**
	 * Find the row, column coordinates of the best element (biggest or smallest) for the given matrix
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicates if the smallest element is the best or not (biggest is then the best)
	 * @return an array of two integer coordinates, row first and then column
	 */
	public static int[] findBest(double[][] matrix, boolean smallestFirst) {
		double best;
		if(smallestFirst)
			best = Double.POSITIVE_INFINITY;
		else
			best = Double.NEGATIVE_INFINITY;

		int row =0, col= 0;

		for (int i = 0; i < matrix.length; i++) {
			for(int j =0; j< matrix[i].length; j++) {
				double element = matrix[i][j];
				if(smallestFirst && element<best) {
					best = element;
					row = i;
					col = j;
				}
				if(!smallestFirst && element >best) {
					best = element;
					row = i;
					col = j;
				}
			}
		}

		return new int[]{row,col};
	}


	/**
	 * Find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean,  indicates if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBest(int n, double[][] matrix, boolean smallestFirst) {
		double[][] matrixCopy = new double[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrixCopy[i][j] = matrix[i][j];
			}
		}
		//double[][] matrixCopy = matrix.clone(); TODO wtf marche pas ?
		int[][] pairs = new int[n][2];

		for(int i=0; i<n; i++) {
			int[] position = findBest(matrixCopy, smallestFirst);
			pairs[i] = position;
			if(smallestFirst) {
				matrixCopy[position[0]][position[1]] = Double.POSITIVE_INFINITY;
				System.out.println(matrix[position[0]][position[1]]);
			}
			else
				matrixCopy[position[0]][position[1]] = Double.NEGATIVE_INFINITY;
		}
		return pairs;
	}



	/**
	 * BONUS 
	 * Notice : Bonus points are underpriced ! 
	 * 
	 * Sorts all the row, column coordinates based on their pixel value
	 * Hint : Use recursion !
	 * @param matrix : an 2D array of doubles
	 * @return A list of points, each point is an array of length 2.
	 */
	public static ArrayList<int[]> quicksortPixelCoordinates(double[][] matrix) {

		// TODO implement me correctly for "underpriced" bonus!
		return new ArrayList<int[]>();
	}


	/**
	 * BONUS
	 * Notice : Bonus points are underpriced !
	 * 
	 * Use a quick sort to find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * Hint : return the n first or n last elements of a sorted ArrayList  
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicate if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBestQuickSort(int n, double[][] matrix, boolean smallestFirst) {

		// TODO implement me correctly for underpriced bonus!
		return new int[][]{};
	}
}
