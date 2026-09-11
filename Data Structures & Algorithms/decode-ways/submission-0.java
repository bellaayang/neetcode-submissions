class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    String s;
    public int numDecodings(String s) {
        this.s = s;
        return helper(0);
        
    }

    public int helper (int i) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int ways = 0;
        ways += helper(i + 1);

        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
            ways += helper(i + 2);
        }

        dp.put(i, ways);
        return ways;
    }
}
