class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, words, r, c, root);
            }
        }

        return res;

        
    }

    private void dfs(char[][] board, String[] words, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '*' || node.children[board[r][c] - 'a'] == null) {
            return;
        }

        char temp = board[r][c];
        board[r][c] = '*';
        node = node.children[temp - 'a'];

        if (node.idx != -1) {
            res.add(words[node.idx]);
            node.idx = -1;
        }

        dfs(board, words, r + 1, c, node);
        dfs(board, words, r - 1, c, node);
        dfs(board, words, r, c + 1, node);
        dfs(board, words, r, c - 1, node);

        board[r][c] = temp;

    }

    class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;

    public void addWord(String word, int i) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.idx = i;
    }
}
}
