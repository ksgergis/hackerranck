import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//question link https://www.hackerrank.com/challenges/hackerland-radio-transmitters

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		// treeset is the best data structure in my opinion
		// I can loop through the data in order way, and at the same time I can
		// check if there is
		// house in specific location in O(1)
		Set<Integer> houses = new TreeSet<>();

		for (int x_i = 0; x_i < n; x_i++) {
			houses.add(in.nextInt());
		}
		// the algorithm is simple, for each house, First I check if it's in
		// coverage range from previous transmitter, then I skip doing anything.
		// if it's not, then I start a loop from the furtherst house at
		// currentLocation + k to my current location, until I find the first
		// furtherst a house I install transmitter there, then this house will
		// also cover from it's location to location + k, and thats become my
		// new coverage range
		int lastCovered = -1;
		int numOfTransmitters = 0;
		for (int houseLocation : houses) {
			if (houseLocation <= lastCovered)
				continue;
			int newTransmitterLocation = 0;
			for (int tempLocation = houseLocation + k; tempLocation >= houseLocation; tempLocation--) {
				if (houses.contains(tempLocation)) {
					newTransmitterLocation = tempLocation;
					lastCovered = newTransmitterLocation + k;
					numOfTransmitters++;
					break;
				}
			}
		}
		System.out.println(numOfTransmitters);
	}
}
