import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static HashMap<String, Integer> max = new HashMap<>();

	static int getMoneySpent(int[] keyboards, int[] drives, int s) {
		// Complete this function
		Arrays.sort(keyboards);
		Arrays.sort(drives);
		int moneySpent = -1;
		int firstK = getFirstElement(keyboards, s);
		int firstD = getFirstElement(drives, s);
		return getMonSpentRec(keyboards, drives, s, firstK, firstD);

	}

	public static int getMonSpentRec(int[] keyboards, int[] drives, int s, int kIndex, int dIndex) {
		if (kIndex < 0 || dIndex < 0) {
			return -1;
		}
		if (max.get(kIndex + "_" + dIndex) != null) {
			return max.get(kIndex + "_" + dIndex);
		}
		if (keyboards[kIndex] + drives[dIndex] <= s) {
			max.put(kIndex + "_" + dIndex, keyboards[kIndex] + drives[dIndex]);
			return keyboards[kIndex] + drives[dIndex];
		} else {
			int maxValue = max(getMonSpentRec(keyboards, drives, s, kIndex - 1, dIndex),
					getMonSpentRec(keyboards, drives, s, kIndex, dIndex - 1));
			max.put(kIndex + "_" + dIndex, maxValue);
			return maxValue;
		}
	}

	public static int getFirstElement(int[] array, int upperLimit) {
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] <= upperLimit) {
				return i;
			}
		}
		return -1;
	}

	public static int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] keyboards = new int[n];
		for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
			keyboards[keyboards_i] = in.nextInt();
		}
		int[] drives = new int[m];
		for (int drives_i = 0; drives_i < m; drives_i++) {
			drives[drives_i] = in.nextInt();
		}
		// The maximum amount of money she can spend on a keyboard and USB
		// drive, or -1 if she can't purchase both items
		int moneySpent = getMoneySpent(keyboards, drives, s);
		System.out.println(moneySpent);
	}
}
