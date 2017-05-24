import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//not finished yet

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int r = in.nextInt();

		int[][] grid = new int[n][m];
		int[][] rotatedGrid = new int[n][m];

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				grid[row][col] = in.nextInt();
			}
		}

		int firstRow = 0;
		int firstCol = 0;
		int lastRow = n - 1;
		int lastCol = m - 1;
		while (firstRow < lastRow && firstCol < lastCol) {
			
			for (int colIndex = firstCol; colIndex <= lastCol; colIndex++) {
				int newIndex = colIndex - r;
				int numOfSides = 0;
				
			}

			for (int row = firstRow; row <= lastRow; row++) {

			}

			firstRow++;
			lastRow--;
			firstCol++;
			lastCol--;
		}
	}
}
