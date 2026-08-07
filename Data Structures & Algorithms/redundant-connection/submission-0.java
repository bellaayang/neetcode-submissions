class Solution {
    int[] father;
    int[] res = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        father = new int[edges.length + 1];
        for (int i = 1; i < edges.length + 1; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return res;
        
    }

     private int find (int u) {
        if (father[u] == u) {
            return u;
        }

        return father[u] = find(father[u]);
    }

    private void union (int u, int v) {
        int uRoot = find(u);
        int vRoot = find(v);
        if (uRoot == vRoot) {
            res = new int[] {u, v};
            return;
        }

        father[vRoot] = uRoot;
    }
}
