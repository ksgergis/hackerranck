//question link https://www.hackerrank.com/challenges/kaprekar-numbers
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		long start = console.nextLong();
		long end = console.nextLong();
		boolean found = false;
		for (long num = start; num <= end; num++) {
			String sqr = (long) Math.pow(num, 2) + "";
			// System.out.println("length " + sqr.length() );
			if (sqr.length() == 1) {
				if (num == 1) {
					System.out.print("1 ");
					found = true;
				}
				continue;
			}
			long left = Long.valueOf(sqr.substring(0, sqr.length() / 2));
			long right = Long.valueOf(sqr.substring(sqr.length() / 2));
			if (left + right == num) {
				System.out.print(num + " ");
				found = true;
			}

		}
		if (!found) {
			System.out.println("INVALID RANGE");
		}
	}
}
	
	