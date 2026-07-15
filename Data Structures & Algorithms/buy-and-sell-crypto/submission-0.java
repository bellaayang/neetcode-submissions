class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = 1;
        int result = 0;
        while (rightIndex < prices.length) {
            if (prices[rightIndex] - prices[leftIndex] < 0) {
                leftIndex = rightIndex;
                rightIndex++;
            } else {
                result = Math.max(result,prices[rightIndex] - prices[leftIndex]);
                rightIndex++;
            }
        }

        return result;
        
    }
}
