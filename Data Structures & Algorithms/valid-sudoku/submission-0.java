class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] grids = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int gridX = i / 3;
                int gridY = j / 3;
                int gridIndex = gridX * 3 + gridY;

                if (rows[i].contains(c) || columns[j].contains(c) || grids[gridIndex].contains(c)) {
                    return false;
                }

                rows[i].add(c);
                columns[j].add(c);
                grids[gridIndex].add(c);
            }
        }

        return true;
    }
}
