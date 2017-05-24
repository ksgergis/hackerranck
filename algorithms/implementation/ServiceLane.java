//question link https://www.hackerrank.com/challenges/service-lane
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int[] serviceLane = new int[arraySize];
		int testCases = in.nextInt();
		for (int i = 0; i < arraySize; i++) {
			serviceLane[i] = in.nextInt();
		}
		for (int i = 0; i < testCases; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			int max = 3;
			for (int laneIndex = start; laneIndex <= end; laneIndex++) {
				if (serviceLane[laneIndex] < max) {
					max = serviceLane[laneIndex];
					if (max == 1) {
						break;
					}
				}
			}
			System.out.println(max);
		}

	}
}
