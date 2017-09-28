//question link https://www.hackerrank.com/challenges/truck-tour

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Pump[] pumps = new Pump[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			Pump pump = new Pump(scanner.nextInt(), scanner.nextInt());
			pumps[i] = pump;
		}
		for (int startStation = 0; startStation < n; startStation++) {
			if (visited[startStation]) {
				continue;
			}
			long tank = 0;
			boolean isTripCompleted = true;
			for (int i = startStation; i < n; i++) {
				visited[i] = true;
				Pump pump = pumps[i];
				tank += pump.gasAmount - pump.nextStationDistance;
				if (tank < 0) {
					isTripCompleted = false;
					break;
				}
			}
			if (isTripCompleted) {
				System.out.println(startStation);
				break;
			}
		}

	}
}

class Pump {
	int gasAmount;
	int nextStationDistance;

	public Pump(int gasAmount, int nextStationDistance) {
		this.gasAmount = gasAmount;
		this.nextStationDistance = nextStationDistance;
	}

}