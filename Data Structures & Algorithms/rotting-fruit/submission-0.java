class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] directions = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

        int fresh = 0;
        int time = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for (int[] direction : directions) {
                    int rowNext = row + direction[0];
                    int colNext = col + direction[1];
                    if (rowNext < 0 || colNext < 0 || rowNext >= ROW || colNext >= COL || grid[rowNext][colNext] != 1) {
                        continue;
                    }
                    grid[rowNext][colNext] = 2;
                    queue.add(new int[] { rowNext, colNext });
                    fresh--;
                }
            }
            time++;
        }

        if (fresh == 0) {
            return time;
        }

        return -1;
        
    }
}
