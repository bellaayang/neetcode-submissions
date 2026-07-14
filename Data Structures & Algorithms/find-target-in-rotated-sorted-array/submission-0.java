class Solution {
    public int search(int[] nums, int target) {
         int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[midIndex] >= nums[leftIndex]) {
                if (target < nums[leftIndex] || target > nums[midIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            } else {
                if (target > nums[rightIndex] || target < nums[midIndex]) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
        }

        return -1;
        
    }
}
