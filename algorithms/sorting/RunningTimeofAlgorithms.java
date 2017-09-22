// question link: https://www.hackerrank.com/challenges/runningtime
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfElements = scanner.nextInt();
		int[] elements = new int[numOfElements];
		for (int i = 0; i < numOfElements; i++) {
			elements[i] = scanner.nextInt();
		}
		int numOfShifts = 0;
		for (int currentElementIndex = 1; currentElementIndex < elements.length; currentElementIndex++) {
			int tempCurrentElementIndex = currentElementIndex;
			while (tempCurrentElementIndex > 0
					&& elements[tempCurrentElementIndex] < elements[tempCurrentElementIndex - 1]) {
				swap(elements, tempCurrentElementIndex,
						tempCurrentElementIndex - 1);
				
				numOfShifts++;
				tempCurrentElementIndex--;
			}
		}
		System.out.println(numOfShifts);
	}

	private static void swap(int[] elements, int currentElementIndex,
			int preElementsIndex) {
		// TODO Auto-generated method stub
		int temp = elements[currentElementIndex];
		elements[currentElementIndex] = elements[preElementsIndex];
		elements[preElementsIndex] = temp;

	}
}
