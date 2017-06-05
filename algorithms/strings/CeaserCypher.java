import java.util.Scanner;

public class Solution {
	static int maxTcc = 0;

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int len = console.nextInt();
		String unEncString = console.next();
		int key = console.nextInt();
		StringBuilder encString = new StringBuilder();
		for (char ch : unEncString.toCharArray()) {
			if (ch >= 65 && ch <= 90) {
				char temp = (char) (ch + key);
				while (temp > 90) {
					temp = (char) (65 + (temp % 91));
				}
				encString.append(temp);
			} else if (ch >= 97 && ch <= 122) {
				char temp = (char) (ch + key);
				while (temp > 122) {
					temp = (char) (97 + (temp % 123));
				}
				encString.append(temp);
			} else {
				encString.append(ch);
			}
		}
		System.out.println(encString);

	}

}