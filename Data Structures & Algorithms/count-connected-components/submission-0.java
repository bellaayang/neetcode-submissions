class Solution {
    int[] father;
    int count;
    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            union(u, v);
        }

        return count;
    }

    private int find (int u) {
        if (father[u] == u) {
            return u;
        }

        return father[u] = find (father[u]);
    }

    private void union (int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            return;
        }

        father[rootV] = rootU;
        count--;
    }

    
}
