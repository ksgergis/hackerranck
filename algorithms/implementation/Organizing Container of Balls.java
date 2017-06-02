//question link https://www.hackerrank.com/challenges/organizing-containers-of-balls
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			long[][] containers = new long[n][n];
			HashMap<Integer, Long> ballsTypeCount = new HashMap<>();
			HashMap<Integer, Long> containerBallsCount = new HashMap<>();
			for (int containerId = 0; containerId < n; containerId++) {
				for (int ballId = 0; ballId < n; ballId++) {
					long ballCount = in.nextLong();
					containers[containerId][ballId] = ballCount;
					ballsTypeCount.put(ballId, ballsTypeCount.getOrDefault(ballId, 0L) + ballCount);
					containerBallsCount.put(containerId, containerBallsCount.getOrDefault(containerId, 0L) + ballCount);
				}
			}
			// for each container, try to find ball type that has the same
			// number of balls as what the container currently holding
			outer: for (int containerId = 0; containerId < n; containerId++) {
				long containerTotalBalls = containerBallsCount.get(containerId);
				for (Entry<Integer, Long> ballTypeCount : ballsTypeCount.entrySet()) {
					if (containerTotalBalls == ballTypeCount.getValue()) {
						ballsTypeCount.remove(ballTypeCount.getKey());
						continue outer;
					}
				}
			}
			if (ballsTypeCount.isEmpty()) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}
}
