//question link https://www.hackerrank.com/challenges/journey-to-the-moon
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numOfAstronuts = in.nextInt();
		int numOfConnections = in.nextInt();
		Graph graph = new Graph(numOfAstronuts);
		for (int a1 = 0; a1 < numOfConnections; a1++) {
			int astrount1 = in.nextInt();
			int astrount2 = in.nextInt();
			graph.addEdge(astrount1, astrount2);
		}
		boolean[] visited = new boolean[numOfAstronuts];
		long numOfWays = 0;
		List<Long> groups = new LinkedList<>();
		List<Long> indv = new LinkedList<>();
		for (int i = 0; i < numOfAstronuts; i++) {
			if (!visited[i]) {
				long relatedAstronuts = numOfAsronuts(graph, i, visited);
				for (long groupNum : groups) {
					numOfWays += (relatedAstronuts * groupNum);
				}
				numOfWays += +(relatedAstronuts * indv.size());
				if (relatedAstronuts == 1) {
					indv.add(relatedAstronuts);
				} else {
					groups.add(relatedAstronuts);
				}
			}
		}
		System.out.println(numOfWays);
	}

	static long numOfAsronuts(Graph graph, int astronutId, boolean[] visited) {
		visited[astronutId] = true;
		long numOfAsronuts = 1;
		for (int neighbourAstronut : graph.getAdjNode(astronutId)) {
			if (!visited[neighbourAstronut]) {
				numOfAsronuts += numOfAsronuts(graph, neighbourAstronut, visited);
			}
		}
		return numOfAsronuts;
	}
}

class Graph {
	LinkedList<Integer>[] edges;

	public Graph(int n) {
		edges = new LinkedList[n];
		for (int i = 0; i < n; i++) {
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
