class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast();
            }

            dq.addLast(right);
            if (left > dq.getFirst()) {
                dq.removeFirst();
            }

            if (right + 1 >= k) {
                result[left] = nums[dq.getFirst()];
                left++;
            }

        }

        return result;
        
        
    }
}
