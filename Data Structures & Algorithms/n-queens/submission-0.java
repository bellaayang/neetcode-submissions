class Solution {
    List<List<String>> result = new LinkedList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> posDia = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
            
        }
        
        backtracking(n, board, 0);
        return result;
        
    }

    private void backtracking(int n, char[][] board, int row) {
        if (row == n) {
            List<String> path = new LinkedList<>();
            for (char[] r : board) {
                path.add(new String(r));
            }
            result.add(new LinkedList<>(path));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || negDiag.contains(row - c) || posDia.contains(row + c)) {
                continue;
            }

            col.add(c);
            negDiag.add(row - c);
            posDia.add(row + c);
            board[row][c] = 'Q';
            backtracking(n, board, row + 1);
            col.remove(c);
            negDiag.remove(row - c);
            posDia.remove(row + c);
            board[row][c] = '.';
        }
    }
}
