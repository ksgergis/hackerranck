import java.util.Scanner;

public class Solution {

	static int[] leftRotation(int[] a, int d) {
		// Complete this function
		int[] resultArray = new int[a.length];
		for (int index = d, resultIndex = 0; resultIndex < a.length; index = (index + 1)
				% a.length, resultIndex++) {
			resultArray[resultIndex] = a[index];
		}
		return resultArray;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] result = leftRotation(a, d);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");

		in.close();
	}
}
