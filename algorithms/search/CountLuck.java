//question link https://www.hackerrank.com/challenges/count-luck
import java.util.Scanner;

public class Solution {

	static boolean mFound = false;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();
		for (int i = 0; i < t; i++) {
			n = console.nextInt();
			m = console.nextInt();
			char[][] woods = new char[n][m];
			mFound = false;
			int startRow = 0;
			int startCol = 0;
			for (int row = 0; row < n; row++) {
				String rowString = console.next();
				for (int col = 0; col < m; col++) {
					woods[row][col] = rowString.charAt(col);
					if (woods[row][col] == 'M') {
						startRow = row;
						startCol = col;
					}
				}
			}
			int ronGuess = console.nextInt();
			isRonRight(woods, startRow, startCol, 0, ronGuess);
		}
	}

	public static void isRonRight(char[][] woods, int row, int col, int numOfWandUsed, int ronGuess) {
		if (mFound || isBlocked(woods, row, col)) {
			return;
		}

		if (woods[row][col] == '*') {
			System.out.println(numOfWandUsed == ronGuess ? "Impressed" : "Oops!");
			mFound = true;
			return;
		}
		woods[row][col] = 'X';
		
		int numOfWays = (isBlocked(woods, row + 1, col) ? 0 : 1) + (isBlocked(woods, row - 1, col) ? 0 : 1)
				+ (isBlocked(woods, row, col + 1) ? 0 : 1) + (isBlocked(woods, row, col - 1) ? 0 : 1);
		if (numOfWays == 0) {
			return;
		} else if (numOfWays > 1) {
			numOfWandUsed++;
		}
		isRonRight(woods, row + 1, col, numOfWandUsed, ronGuess);
		isRonRight(woods, row - 1, col, numOfWandUsed, ronGuess);
		isRonRight(woods, row, col + 1, numOfWandUsed, ronGuess);
		isRonRight(woods, row, col - 1, numOfWandUsed, ronGuess);

	}

	public static boolean isBlocked(char[][] woods, int row, int col) {
		//System.out.println("a7a " + row + " " + " col");
		if (row >= n || row < 0 || col < 0 || col >= m || woods[row][col] == 'X') {
			return true;
		}
		return false;
	}

}