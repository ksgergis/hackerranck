//question link https://www.hackerrank.com/challenges/kruskalmstrsub
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		int m = console.nextInt();
		Graph graph = new Graph(n);
		for (int i = 0; i < m; i++) {
			graph.addEdge(console.nextInt(), console.nextInt(), console.nextInt());
		}
		List<Edge> edges = graph.getAllEdges();
		Collections.sort(edges);
		SubGraphUnion visited = new SubGraphUnion(n+1);
		long result = 0;
		for (Edge edge : edges) {
			if (visited.isConnected(edge.u, edge.v)) {
				continue;
			}
			visited.connect(edge.u, edge.v);
			result+=edge.weight;
		}
		System.out.println(result);
	}
}

class Graph {
	private static final int nodesSize = 0;
	List<Edge>[] nodes;
	List<Edge> edges;

	public Graph(int nodesSize) {
		edges = new ArrayList<>();
		nodes = new List[nodesSize+1];
		for (int nodeId = 1; nodeId <= nodesSize; nodeId++) {
			nodes[nodeId] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v, int weight) {
		Edge e = new Edge(u, v, weight);
		nodes[u].add(e);
		nodes[v].add(e);
		edges.add(e);
	}

	public List<Edge> getAdj(int u) {
		return nodes[u];
	}

	public List<Edge> getAllEdges() {
		return edges;
	}
}

class Edge implements Comparable<Edge> {
	public int u;
	public int v;
	public int weight;

	public Edge(int u, int v, int weight) {
		super();
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u;
		result = prime * result + v;
		result = prime * result + weight;
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
		Edge other = (Edge) obj;
		if (u != other.u)
			return false;
		if (v != other.v)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return new Integer(weight).compareTo(o.weight);
	}

}

class SubGraphUnion {
	int[] data;
	int[] weight;

	public SubGraphUnion(int size) {
		data = new int[size];
		weight = new int[size];
		for (int x = 0; x < size; x++) {
			data[x] = x;
			weight[x] = 1;
		}
	}

	public int root(int i) {
		while (i != data[i]) {
			data[i] = data[data[i]];
			i = data[i];
		}
		return i;
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public void connect(int p, int q) {
		int qRoot = root(q);
		int pRoot = root(p);
		if (weight[qRoot] > weight[pRoot]) {
			data[pRoot] = qRoot;
			weight[qRoot] += weight[pRoot];
		} else {
			data[qRoot] = pRoot;
			weight[pRoot] += weight[qRoot];
		}

	}
}

