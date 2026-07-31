class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();
        int ROW = heights.length;
        int COL = heights[0].length;
        
        boolean [][] pacific = new boolean[ROW][COL];
        boolean [][] atlantic = new boolean[ROW][COL];

        for (int c = 0; c < COL; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, ROW - 1, c);
        }

        for (int r = 0; r < ROW; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, COL - 1);
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true) {
                    result.add(Arrays.asList(i, j));
                }
                
            }
            
        }

        return result;
        
    }

    private void dfs(int[][] heights, boolean [][] ocean, int r, int c) {
        ocean[r][c] = true;
        for (int[] direction : directions) {
            int rowNext = r + direction[0];
            int colNext = c + direction[1];
            
            if (rowNext < 0 || colNext < 0 || rowNext >= heights.length || colNext >= heights[0].length || heights[rowNext][colNext] < heights[r][c] || ocean[rowNext][colNext] == true) {
                continue;
            }
            dfs(heights, ocean, rowNext, colNext);

        }
}
}
