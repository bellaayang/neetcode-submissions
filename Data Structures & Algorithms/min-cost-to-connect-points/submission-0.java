class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[]{dist, j});
                adj.get(j).add(new int[]{dist, i});
            }
            
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Set<Integer> visited = new HashSet<>();
        int res = 0;

        minHeap.offer(new int[]{0, 0});
        while (visited.size() < points.length) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int i = curr[1];
            if (visited.contains(i)) {
                continue;
            }

            res += cost;
            visited.add(i);

            List<int[]> nodes = adj.get(i);
            for (int[] nei : nodes) {
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if (!visited.contains(neiIndex)) {
                    minHeap.offer(new int[]{neiCost, neiIndex});
                }
            }
        }

        return res;
        
    }
}
