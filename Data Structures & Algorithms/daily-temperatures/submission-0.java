class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                int curIndex = stack.peek();
                if (temperatures[curIndex] < temperatures[i]) {
                    result[curIndex] = i - curIndex;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;

        }

        return result;
        
    }
}
