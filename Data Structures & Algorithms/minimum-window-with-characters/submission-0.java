class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        int sCount = 0;
        int tCount = t.length();

        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            sMap.put(cur, sMap.getOrDefault(cur, 0) + 1);
            if (tMap.containsKey(cur) && tMap.get(cur) >= sMap.get(cur)) {
                sCount++;
            }

            while (sCount == tCount) {
                if (right - left + 1 < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.getOrDefault(leftChar, 0) - 1);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    sCount--;
                }
                left++;
            }
        }

        if (resLen == Integer.MAX_VALUE) {
            return "";
        }
       
        return s.substring(res[0], res[1] + 1);
        
    }
}
