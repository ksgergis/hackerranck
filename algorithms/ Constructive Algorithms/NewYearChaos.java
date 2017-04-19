import java.util.Scanner;

//question link https://www.hackerrank.com/challenges/new-year-chaos
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int testNumber = 0; testNumber < t; testNumber++) {
			int n = scan.nextInt();
			int numOfPripes = 0;
			int currentPosition = 1;
			boolean tooChaiotic = false;
			int[] originalQueue = new int[n + 1];
			int[] pripedQueue = new int[n + 1];
			for (currentPosition = 1; currentPosition <= n; currentPosition++) {
				originalQueue[currentPosition] = currentPosition;
				pripedQueue[currentPosition] = scan.nextInt();
			}

			for (currentPosition = 1; currentPosition <= n; currentPosition++) {

				if (originalQueue[currentPosition] != pripedQueue[currentPosition]) {
					if (pripedQueue[currentPosition] != getAtPosition(originalQueue, currentPosition + 1)
							&& pripedQueue[currentPosition] != getAtPosition(originalQueue, currentPosition + 2)) {
						System.out.println("Too chaotic");
						tooChaiotic = true;
						break;
					} else {
						if (pripedQueue[currentPosition] == originalQueue[currentPosition + 1]) {

							int temp = originalQueue[currentPosition];
							originalQueue[currentPosition] = originalQueue[currentPosition + 1];
							originalQueue[currentPosition + 1] = temp;
							numOfPripes += 1;
						} else {
							int temp = originalQueue[currentPosition + 2];
							originalQueue[currentPosition + 2] = originalQueue[currentPosition + 1];
							originalQueue[currentPosition + 1] = originalQueue[currentPosition];
							originalQueue[currentPosition] = temp;
							numOfPripes += 2;
						}
					}
				}
			}
			if (!tooChaiotic) {
				System.out.println(numOfPripes);
			}
		}
	}

	public static int getAtPosition(int[] queue, int position) {
		try {
			return queue[position];
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
}