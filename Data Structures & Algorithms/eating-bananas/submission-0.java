class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            double time = 0;
            for (int i = 0; i < piles.length; i++) {
                time += Math.ceil((double) piles[i] / mid) ;
            }

            if (time <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
        
        
    }
}
