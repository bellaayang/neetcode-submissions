class Solution {
    public int trap(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];
        int result = 0;

        while (leftIndex < rightIndex) {
            if (leftMax < rightMax) {
                result += Math.max(0, leftMax - height[leftIndex]);
                leftIndex++;
                leftMax = Math.max(leftMax, height[leftIndex]);
            } else {
                result += Math.max(0, rightMax - height[rightIndex]);
                rightIndex--;
                rightMax = Math.max(rightMax, height[rightIndex]);
            }
        }

        return result;
        
    }
}
