//question link https://www.hackerrank.com/challenges/even-tree
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int vert = console.nextInt();
		Graph graph = new Graph(vert);
		int edges = console.nextInt();
		for (int i = 0; i < edges; i++) {
			int u = console.nextInt();
			int v = console.nextInt();
			graph.connect(u, v);
		}

		int numOfSplits = maxSplits(graph, 1);
		System.out.println(numOfSplits);
	}

	private static int maxSplits(Graph graph, int v) {

		if (graph.adj(v).isEmpty()) {
			return 0;
		}
		int maxSplits = 0;
		for (int childIndex = 0; childIndex < graph.adj(v).size(); childIndex++) {
			int child = graph.adj(v).get(childIndex);
			int childCount = graph.count(child);
			if (childCount >= 2 && childCount % 2 == 0) {	
				maxSplits++;
			}
			maxSplits += maxSplits(graph, child);
		}
		return maxSplits;
	}
}

class Graph {
	private int v;
	List<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		adj = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			adj[i] = new ArrayList<>();
		}

	}

	public void connect(int u, int v) {
		adj[v].add(u);
	}

	public List<Integer> adj(int u) {
		return adj[u];
	}

	public int count(int v) {
		if (adj[v].isEmpty()) {
			return 1;
		}
		int count = 1;
		for (int adjNode : adj[v]) {
			count += count(adjNode);
		}
		return count;
	}
}
