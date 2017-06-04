import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();
		HashSet<Pair> pairs = new HashSet<>();
		HashSet<Long> nums = new HashSet<>();
		for (int i = 0; i < n; i++) {
			nums.add(in.nextLong());
		}
		for (long num : nums) {
			if (nums.contains(num + k)) {
				pairs.add(new Pair(num, num + k));
			}
			if (nums.contains(Math.abs(num - k))) {

			}
		}
		System.out.println(pairs.size());
	}
	
}

class Pair {
	long num1;
	long num2;

	public Pair(long num1, long num2) {
		this.num1 = Math.min(num1, num2);
		this.num2 = Math.max(num1, num2);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (num1 ^ (num1 >>> 32));
		result = prime * result + (int) (num2 ^ (num2 >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (num1 != other.num1)
			return false;
		if (num2 != other.num2)
			return false;
		return true;
	}
}
