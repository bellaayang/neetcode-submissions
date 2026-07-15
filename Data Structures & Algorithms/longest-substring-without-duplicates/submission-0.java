class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        char[] array = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < array.length; right++) {
            if (map.containsKey(array[right]) && map.get(array[right]) >= left) {
                left = map.get(array[right]) + 1;
            }
            map.put(array[right], right);
            res = Math.max (res, right - left + 1);
        }

        return res;
        
    }
}
