class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= curEnd) {
                curEnd = Math.max(curEnd, end);
            } else {
                res.add(new int[]{curStart, curEnd});
                curStart = start;
                curEnd = end;
            }
        }

        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][]);
        
        
    }
}
