class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    island++;
                }
                
            }
            
        }
        return island;
        
    }

    private void bfs (char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for (int[] direction : directions) {
                int rNext = row + direction[0];
                int cNext = col + direction[1];

                if (rNext >= 0 && cNext >= 0 && rNext < grid.length && cNext < grid[0].length && grid[rNext][cNext] == '1') {
                    queue.add(new int[]{rNext, cNext});
                    grid[rNext][cNext] = '0';
                }

            }

        }

    }
}
