class Solution {
    public int search(int[] nums, int target) {
         int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = nums[midIndex];
            if (mid == target) {
                return midIndex;
            } else if (mid < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }

        return -1;
        
    }
}
