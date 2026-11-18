class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == grid.length - 1 && c == grid.length - 1) {
                return t;
            }

            for (int[] d : directions) {
                int neiR = d[0] + r;
                int neiC = d[1] + c;
                if (neiR >= 0 && neiR < grid.length && neiC >= 0 && neiC < grid.length && !visited[neiR][neiC]) {
                    minHeap.offer(new int[]{Math.max(t, grid[neiR][neiC]), neiR, neiC});
                    visited[neiR][neiC] = true;

                }
            }
        }

        return -1;
        
    }
}
