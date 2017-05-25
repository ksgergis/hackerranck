//question link https://www.hackerrank.com/challenges/grid-challenge
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int testCases = console.nextInt();
		outer: for (int i = 0; i < testCases; i++) {
			int gridSize = console.nextInt();
			char[][] grid = new char[gridSize][gridSize];
			for (int row = 0; row < gridSize; row++) {
				String rowString = console.next();
				for (int col = 0; col < gridSize; col++) {
					grid[row][col] = rowString.charAt(col);
				}
				Arrays.sort(grid[row]);
			}

			for (int col = 0; col < gridSize; col++) {
				for (int row = 1; row < gridSize; row++) {
					if (grid[row][col] < grid[row - 1][col]) {
						System.out.println("NO");
						continue outer;
					}
				}
			}
			System.out.println("YES");
		}

	}
}