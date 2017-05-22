//question link https://www.hackerrank.com/challenges/the-grid-search
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		outer: for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			int C = in.nextInt();
			char[][] grid = new char[R][C];
			for (int row = 0; row < R; row++) {
				String rowString = in.next();
				for (int col = 0; col < C; col++) {
					grid[row][col] = rowString.charAt(col);
				}
			}
			int r = in.nextInt();
			int c = in.nextInt();
			char[][] subGrid = new char[r][c];
			for (int row = 0; row < r; row++) {
				String rowString = in.next();
				for (int col = 0; col < c; col++) {
					subGrid[row][col] = rowString.charAt(col);
				}
			}

			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (grid[row][col] == subGrid[0][0]) {
						if (isSubGrid(subGrid, grid, row, col)) {
							System.out.println("YES");
							continue outer;

						}
					}
				}
			}
			System.out.println("NO");
		}

	}

	private static boolean isSubGrid(char[][] subGrid, char[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		if (row + subGrid.length > grid.length) {
			return false;
		}
		if (col + subGrid[0].length > grid[0].length) {
			return false;
		}
		for (int r = 0; r < subGrid.length; r++) {
			for (int c = 0; c < subGrid[0].length; c++) {
				if (subGrid[r][c] != grid[row + r][col + c]) {
					return false;
				}
			}
		}
		return true;
	}

}
