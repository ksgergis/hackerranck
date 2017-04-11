import java.io.*;
import java.util.*;

//question link: https://www.hackerrank.com/challenges/jesse-and-cookies?h_r=next-challenge&h_v=zen
public class Solution {

	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		Scanner console = new Scanner(System.in);
		int numOfCookies = console.nextInt();
		int minRequiredSweetnes = console.nextInt();
		for (int x = 0; x < numOfCookies; x++) {
			heap.add(console.nextInt());
		}
		System.out.println(getNumOfSteps(heap, minRequiredSweetnes));
	}

	public static int getNumOfSteps(PriorityQueue<Integer> heap, int minRequiredSweetnes) {
		int numOfSteps = 0;
		while (!heap.isEmpty() && heap.peek() < minRequiredSweetnes) {
			int leastSweetest = heap.poll();
			int secondLeastSweetest = heap.peek() == null ? -1 : heap.poll();
			if (secondLeastSweetest == -1) {
				break;
			}
			int newCookie = leastSweetest * 1 + secondLeastSweetest * 2;
			heap.add(newCookie);
			numOfSteps++;
		}
		return !heap.isEmpty() && minRequiredSweetnes <= heap.peek() ? numOfSteps : -1;
	}
}