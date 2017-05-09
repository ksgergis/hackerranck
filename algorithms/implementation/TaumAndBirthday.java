//question linkhttps://www.hackerrank.com/challenges/taum-and-bday
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long b = in.nextLong();
			long w = in.nextLong();
			long x = in.nextLong();
			long y = in.nextLong();
			long z = in.nextLong();

			long bCost = y + z < x ? y + z : x;
			long wCost = x + z < y ? x + z : y;
			long minCost = bCost * b + wCost * w;
			System.out.println(minCost);
		}
	}
}
