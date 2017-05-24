//https://www.hackerrank.com/challenges/sherlock-and-squares
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int T = console.nextInt();
		for (int i = 0; i < T; i++) {
			int start = console.nextInt();
			int end = console.nextInt();
			int count = 0;
			for (int num = (int) Math.ceil(Math.sqrt(start)); num * num <= end; num++) {
				count++;
			}
			System.out.println(count);
		}
	}
}