// question link https://www.hackerrank.com/challenges/tutorial-intro
	import java.util.Scanner;

	public class Solution {

		public static void main(String[] args) {
			Scanner console = new Scanner(System.in);
			int numToFind = console.nextInt();
			int[] array = new int[console.nextInt()];
			for (int i = 0; i < array.length; i++) {
				array[i] = console.nextInt();
			}
			console.close();
			find(array, 0, array.length - 1, numToFind);

		}

		private static void find(int[] array, int low, int high, int numToFind) {
			int mid = 0;
			while (low <= high) {
				mid = (low + high) / 2;
				if (array[mid] == numToFind) {
					System.out.println(mid);
					break;
				} else if (array[mid] > numToFind) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			}


		}
	}