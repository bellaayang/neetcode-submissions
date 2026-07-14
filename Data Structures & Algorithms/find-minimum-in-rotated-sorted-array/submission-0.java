class Solution {
    public int findMin(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int result = nums[leftIndex];

        while (leftIndex <= rightIndex) {
            if(nums[leftIndex] < nums[rightIndex]) {
                result = Math.min(result, nums[leftIndex]);
                break;
            }
            int midIndex = (leftIndex + rightIndex) / 2;
            result = Math.min(result, nums[midIndex]);
            if (nums[midIndex] >= nums[leftIndex]) {
                leftIndex = midIndex + 1;
            } else if (nums[midIndex] < nums[leftIndex]) {
                rightIndex = midIndex - 1;
            } 
        }

        return result;
        
    }
}
