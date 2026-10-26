class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int startNew = newInterval[0];
        int endNew = newInterval[1];
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (end < startNew) {
                res.add(new int[]{start, end});
            } else if (start > endNew) {
                if (!inserted) {
                    res.add(new int[]{startNew, endNew});
                    inserted = true;
                }
                res.add(new int[]{start, end});
            } else {
                startNew = Math.min(start, startNew);
                endNew = Math.max(end, endNew);
            }
        }

        if (!inserted) {
            res.add(new int[]{startNew, endNew});
        }

        return res.toArray(new int[res.size()][]);
        
        
    }
}
