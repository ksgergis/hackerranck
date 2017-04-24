//question link: https://www.hackerrank.com/challenges/larrys-array
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner console = new Scanner(System.in);
		int testCases = console.nextInt();
		for (int t = 0; t < testCases; t++) {
			int[] inputArray = new int[console.nextInt() + 1];
			boolean isSorted = true;
			for (int i = 1; i < inputArray.length; i++) {
				inputArray[i] = console.nextInt();
			}
			for (int i = 1; i < inputArray.length; i++) {
				if (isInPlace(inputArray, i)) {
					continue;
				}
				if (i >= inputArray.length - 3) {
					if (isAnyInPlace(inputArray, inputArray.length - 3)) {
						isSorted = false;
						break;
					}
					if (isSorted(rotate(inputArray, inputArray.length - 3), inputArray.length - 3)
							|| isSorted(rotate(inputArray, inputArray.length - 3), inputArray.length - 3)) {
						isSorted = true;
						break;
					} else {
						isSorted = false;
						break;
					}
				} else {
					int iLocation = findNumber(inputArray, i);
					while (!isInPlace(inputArray, i)) {
						if (iLocation >= i + 2) {
							rotate(inputArray, iLocation - 2);
							rotate(inputArray, iLocation - 2);
                            iLocation-=2;
						} else {
							rotate(inputArray, iLocation - 1);
                            iLocation--;
						}
					}
				}
			}
			System.out.println(isSorted == true ? "YES" : "NO");
		}

	}

	public static int findNumber(int[] array, int index) {
		for (int i = index + 1; i < array.length; i++) {
			if (array[i] == index) {
				return i;
			}

		}
		return -1;
	}

	public static int[] rotate(int[] array, int index) {
		int temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = array[index + 2];
		array[index + 2] = temp;
		return array;
	}

	public static boolean isAnyInPlace(int[] array, int index) {
		return isInPlace(array, index) || isInPlace(array, index + 1) || isInPlace(array, index + 2);
	}

	public static boolean isSorted(int[] array, int index) {
		return isInPlace(array, index) && isInPlace(array, index + 1) && isInPlace(array, index + 2);
	}

	public static boolean isInPlace(int[] array, int index) {
		return array[index] == index;
	}
}