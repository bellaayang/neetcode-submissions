class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty()) {
                if (stack.peek()[1] > heights[i]) {
                    maxArea = Math.max((i - stack.peek()[0]) * stack.peek()[1], maxArea);
                    start = stack.peek()[0];
                    stack.poll();
                } else {
                    break;
                }
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] s : stack) {
            int index = s[0];
            int height = s[1];
            maxArea = Math.max(maxArea, (heights.length - index) * height);
        }

        return maxArea;
        
    }
}
