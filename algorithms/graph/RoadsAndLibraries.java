//question link https://www.hackerrank.com/challenges/torque-and-development
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int numOfCities = in.nextInt();
			int numOfRoads = in.nextInt();
			long libraryCost = in.nextLong();
			long roadCost = in.nextLong();
			long totalCost = 0;
			//System.out.println("\n");
			if (libraryCost <= roadCost) {
				for (int a1 = 0; a1 < numOfRoads; a1++) {
					in.nextInt();
					in.nextInt();
				}
				totalCost = numOfCities * libraryCost;
			} else {
				Graph graph = new Graph(numOfCities);
				for (int a1 = 0; a1 < numOfRoads; a1++) {
					int city_1 = in.nextInt();
					int city_2 = in.nextInt();
					graph.addEdge(city_1, city_2);
				}
				boolean[] visited = new boolean[numOfCities+1];
				for (int i = 1; i <= numOfCities; i++) {
					if (!visited[i]) {
						totalCost += libraryCost;
						//System.out.println(numOfRoadsToFix(graph, i, visited));
						totalCost += ((numOfRoadsToFix(graph, i, visited) - 1) * roadCost);
					}
				}
			}
			System.out.println(totalCost);
		}
	}

	static int numOfRoadsToFix(Graph graph, int city, boolean[] visitedCities) {
		visitedCities[city] = true;
		int fixedRoads = 1;
		for (int neighbourCity : graph.getAdjNode(city)) {
			if (!visitedCities[neighbourCity]) {
				fixedRoads += numOfRoadsToFix(graph, neighbourCity, visitedCities);
			}
		}
		return fixedRoads;

	}
}

class Graph {
	LinkedList<Integer>[] edges;

	public Graph(int n) {
		edges = new LinkedList[n+1];
		for (int i = 0; i <= n; i++) {
			edges[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		edges[u].add(v);
		edges[v].add(u);
	}

	public LinkedList<Integer> getAdjNode(int u) {
		return edges[u];
	}

}
