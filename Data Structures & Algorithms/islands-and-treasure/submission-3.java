class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            } 
        }

       
        if (queue.isEmpty()) {
            return;
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            for (int[] direction : directions) {
                int rNext = r + direction[0];
                int cNext = c + direction[1];
                if (rNext < 0 || cNext < 0 || rNext >= ROW || cNext >= COL || grid[rNext][cNext] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[rNext][cNext] = grid[r][c] + 1;
                queue.add(new int[] {rNext, cNext});
            }
            
        }
        
        
    }
}
