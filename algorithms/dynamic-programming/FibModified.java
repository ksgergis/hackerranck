import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		BigInteger t1 = console.nextBigInteger();
		BigInteger t2 = console.nextBigInteger();
		int n = console.nextInt();
		for (int i = 3; i <= n; i++) {
			BigInteger newT2 = t1.add(t2.pow(2));
			t1 = t2;
			t2 = newT2;
		}
		System.out.println(t2);
	}
}