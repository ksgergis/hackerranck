//https://www.hackerrank.com/challenges/an-interesting-game-1
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = in.nextInt();
			}
			int count = 0;
			int lastElement = n - 1;
			while (lastElement >= 0) {
				lastElement = getMax(lastElement, game) - 1;
				// System.out.println(lastElement);
				count++;
			}
			System.out.println(count % 2 == 0 ? "ANDY" : "BOB");
		}
	}

	private static int getMax(int lastElement, int[] game) {
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i <= lastElement; i++) {
			if (game[i] > max) {
				maxIndex = i;
				max = game[i];
			}
		}
		return maxIndex;
	}
}
