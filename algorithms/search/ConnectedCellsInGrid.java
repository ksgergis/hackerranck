//question link https://www.hackerrank.com/challenges/connected-cell-in-a-grid


import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		int m = console.nextInt();
		int[][] grid = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				grid[row][col] = console.nextInt();
			}
		}
		int maxArea = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (grid[row][col] == 1) {
					int areaSize = countArea(grid, row, col);
					if (areaSize > maxArea)
						maxArea = areaSize;
				}
			}
		}
		System.out.println(maxArea);
	}

	public static int countArea(int[][] grid, int row, int col) {
		if (getAtPosition(grid, row, col) == 0) {
			return 0;
		} else {
			markVisitedAtPosition(grid, row, col);
			return 1 + countArea(grid, row - 1, col - 1) + countArea(grid, row - 1, col)
					+ countArea(grid, row - 1, col + 1) + countArea(grid, row, col - 1) + countArea(grid, row, col + 1)
					+ countArea(grid, row + 1, col - 1) + countArea(grid, row + 1, col)
					+ countArea(grid, row + 1, col + 1);
		}
	}

	public static int getAtPosition(int[][] grid, int row, int col) {
		try {
			return grid[row][col];
		} catch (Exception e) {
			return 0;
		}
	}

	public static void markVisitedAtPosition(int[][] grid, int row, int col) {
		try {
			grid[row][col] = 0;
		} catch (Exception e) {
			return;
		}
	}

}
