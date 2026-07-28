class Solution {
    int ROW;
    int COL;
    Set<Pair<Integer, Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (backtracking(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
        
    }

    private boolean backtracking(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROW || c >= COL || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r, c))) {
            return false;
        }

        path.add(new Pair<>(r, c));
        boolean res = backtracking(board, word, r + 1, c, i + 1) || 
        backtracking(board, word, r - 1, c, i + 1) ||
        backtracking(board, word, r, c + 1, i + 1) ||
        backtracking(board, word, r, c - 1, i + 1);
        path.remove(new Pair<>(r, c));

        return res;

    }
}
