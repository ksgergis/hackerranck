//question link https://www.hackerrank.com/challenges/flatland-space-stations
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numOfCities = console.nextInt();
		int numOfStations = console.nextInt();
		int[] cities = new int[numOfCities];
		for (int i = 0; i < numOfStations; i++) {
			cities[console.nextInt()] = 1;
		}
		int max = 0;
		int nearstLeft = -1;
		int nearstRight = -1;
		for (int i = 0; i < numOfCities; i++) {
			// if the city already has station, skip calculations
			if (cities[i] == 1) {
				nearstLeft = i;
				continue;
			}
			// get the distance from the left.
			int leftLength = 0;
			if (nearstLeft != -1) {
				leftLength = i - nearstLeft;
			} else {
				leftLength = Integer.MAX_VALUE;
			}
			// get the distance from the right
			int rightLength = 0;
			if (nearstRight == -1 || (nearstRight < i && nearstRight >= 0)) {
				nearstRight = findNearstRight(i, cities);
			}
			// if no stations on the right, set right length to large number
			if (nearstRight == -10) {
				rightLength = Integer.MAX_VALUE;
			} else {
				rightLength = nearstRight - i;
			}
			int localMin = Math.min(rightLength, leftLength);
			if(localMin > max){
				max =localMin;
			}

		}
		System.out.println(max);
	}

	private static int findNearstRight(int start, int[] cities) {
		for (int i = start + 1; i < cities.length; i++) {
			if (cities[i] == 1) {
				return i;
			}
		}
		return -10;
	}

}