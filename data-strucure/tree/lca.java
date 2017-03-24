
/* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
//challenge link https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
class LSA {
	static Node lca(Node root, int v1, int v2) {
		if (v1 > v2) {
			int temp = v1;
			v1 = v2;
			v2 = temp;
		}
		return lcaRec(root, v1, v2);

	}

	static Node lcaRec(Node root, int v1, int v2) {
		if (v1 <= root.data && root.data <= v2) {
			return root;
		} else if (root.data < v1) {
			return lcaRec(root.right, v1, v2);
		} else {
			return lcaRec(root.left, v1, v2);
		}
	}
}