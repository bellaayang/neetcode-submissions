class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int left = 0;
        int max = 0;
        int res = 0;
        for(int right = 0; right < array.length; right++) {
            map.put(array[right], map.getOrDefault(array[right], 0) + 1);
            max = Math.max(max, map.get(array[right]));
            while (right - left + 1 - max > k) {
                map.put(array[left], map.get(array[left]) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);


        }

        return res;
        
    }
}
