class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        int one = robAction(nums, 0, length - 2);
        int two = robAction(nums, 1, length - 1);

        return Math.max(one, two);
        
    }

    private int robAction (int[] nums, int start, int end) {
        int length = nums.length;
        int[] dp = new int[length];

        if (end - start == 0) {
            return nums[start];
        }

        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]); 
        }

        return dp[end];
    }
}
