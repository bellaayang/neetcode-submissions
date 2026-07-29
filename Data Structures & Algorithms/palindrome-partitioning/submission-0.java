class Solution {
    List<String> path = new LinkedList<>();
    List<List<String>> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
   
    public List<List<String>> partition(String s) {
        backtracking(s, 0, sb);
        return result;
        
    }

    private void backtracking(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                path.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                path.removeLast();
            } else {
                continue;
            }

            
        }
    }

    private boolean isPalindrome (StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left <= right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
