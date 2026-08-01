class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'O' && ((i == 0 || i == ROW - 1) || (j == 0 || j == COL - 1))) {
                    dfs(board, i, j);
                } 
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] ='O';
                } 
            }
        }
        
        
    }

    private void dfs (char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        for (int[] direction : directions) {
            int rNext = direction[0] + r;
            int cNext = direction[1] + c;
            dfs(board, rNext, cNext);
        }
    }
}
