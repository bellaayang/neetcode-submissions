class Solution {
    List<String> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0);
        return result;
        
    }
    private void backtracking(int n, int open, int close) {
        if (open == n && close == n) {
            result.add(sb.toString());
        }

        if (open < n) {
            sb.append("(");
            backtracking(n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtracking(n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
