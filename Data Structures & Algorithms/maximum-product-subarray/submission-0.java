class Solution {
    public int maxProduct(int[] nums) {
         int res = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tmp = num * curMax;
            curMax = Math.max(num, Math.max(num * curMax, num * curMin));
            curMin = Math.min(num, Math.min(tmp, num * curMin));
            res = Math.max(res, curMax);
        }

        return res;
        
    }
}
