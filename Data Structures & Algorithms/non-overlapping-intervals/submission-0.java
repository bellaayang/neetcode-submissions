class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prevEnd = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            if (curStart >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
        
    }
}
