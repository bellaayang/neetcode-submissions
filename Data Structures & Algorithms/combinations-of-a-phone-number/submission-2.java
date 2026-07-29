class Solution {
    List<String> result = new LinkedList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits, 0);
        return result;
        
    }

    private void backtracking (String digits, int num) {
        if (num == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = numString[digits.charAt(num) - '0'];

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
