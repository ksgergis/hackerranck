//https://www.hackerrank.com/challenges/bfsshortreach
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner console = new Scanner(System.in);
		int q = console.nextInt();
		for (int qI = 0; qI < q; qI++) {
			int nodes = console.nextInt();
			int numOfEdges = console.nextInt();
			Graph graph = new Graph(nodes);
			for (int i = 0; i < numOfEdges; i++) {
				graph.addEdge(console.nextInt(), console.nextInt());
			}
			StringBuilder shortestPathString = new StringBuilder();
		}

	}
}

class Graph {
	private static final int nodesSize = 0;
	List<Integer>[] nodes;

	public Graph(int nodesSize) {
		nodes = new List[nodesSize + 1];
		for (int nodeId = 1; nodeId <= nodesSize; nodeId++) {
			nodes[nodeId] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		nodes[u].add(v);
		nodes[v].add(u);

	}

	public List<Integer> getAdj(int u) {
		return nodes[u];
	}

}
