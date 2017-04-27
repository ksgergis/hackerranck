//question link https://www.hackerrank.com/challenges/almost-sorted
import java.io.*;
import java.util.*;

public class Solution {

	static int loc1 = 0;
	static int loc2 = 0;
	static boolean modified = false;
	static boolean swap = false;
	static boolean reverse = false;
	static boolean no = false;
	static int[] data;

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner console = new Scanner(System.in);
		int arraySize = console.nextInt();
		data = new int[arraySize + 1];

		for (int i = 1; i <= arraySize; i++) {
			data[i] = console.nextInt();
		}

		for (int i = 2; i <= arraySize; i++) {
			if (data[i] > data[i - 1]) {
				continue;
			}
			if (modified) {
				no = true;
				break;
			}
			if (swap(i)) {
				modified = true;
				swap = true;
				i -= 2;
				continue;
			} else if (reverse(i)) {
				modified = true;
				reverse = true;
				i--;
				continue;
			} else {
				no = true;
				break;
			}

		}
		System.out.println(Arrays.toString(data));
		if (no) {
			System.out.println("no");
		} else {
			System.out.println("yes");
			if (swap || reverse) {
				System.out.println((swap ? "swap " : "reverse ") + loc1 + " " + loc2);
			}
		}

	}

	public static boolean reverse(int beg) {
		Stack<Integer> stack = new Stack<>();
		// System.out.println("pushing " + data[beg - 1]);
		stack.push(data[beg - 1]);
		for (int i = beg; i < data.length; i++) {
			if (data[i] < data[i - 1]) {
				// System.out.println("pushing " + data[i]);
				stack.push(data[i]);
			} else {
				break;
			}
		}
		int revBeg = beg - 1;
		loc1 = beg - 1;
		loc2 = beg - 2 + stack.size();
		while (!stack.isEmpty()) {
			data[revBeg++] = stack.pop();
		}
		return true;
	}

	public static boolean swap(int location) {
		int swapToLocation = location;
		int numOfSwapsAv = 0;
		for (int i = location + 1; i < data.length; i++) {
			if (data[i] < data[location]) {
				swapToLocation = i;
				numOfSwapsAv++;
			}
		}
		if (numOfSwapsAv <= 1) {
			swap(location - 1, swapToLocation);
			loc1 = location - 1;
			loc2 = swapToLocation;
			return true;
		} else {
			return false;
		}
	}

	private static void swap(int loc1, int loc2) {
		int temp = data[loc1];
		data[loc1] = data[loc2];
		data[loc2] = temp;
	}
}
