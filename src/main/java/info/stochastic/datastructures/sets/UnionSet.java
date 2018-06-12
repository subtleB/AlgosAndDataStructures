package main.java.info.stochastic.datastructures.sets;

public class UnionSet {
    private int[] parent;
    private int[] rank;
    private int size;

    public UnionSet(int n) {
        parent = new int[n  + 1];
        rank = new int[n + 1];
        size = n;
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    public void union(int firstNode, int secondNode) {
        int fRoot = find(firstNode);
        int sRoot = find(secondNode);

        // In the same set
        if (fRoot == sRoot) {
            return;
        }

        size--;
        if (rank[fRoot] > rank[sRoot]) {
            parent[sRoot] = fRoot;
        } else if  (rank[fRoot] < rank[sRoot]) {
            parent[fRoot] = sRoot;
        } else {
            parent[fRoot] = sRoot;
            rank[sRoot]++;
        }
    }

    public int size() {
        return size;
    }
}