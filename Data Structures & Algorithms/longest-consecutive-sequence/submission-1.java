class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int length = 1;
                int current = nums[i];
                while (set.contains(current + 1)) {
                    length++;
                    current++;
                }
                longest = Math.max(longest, length);
            }
            
        }

        return longest;
    }
}
