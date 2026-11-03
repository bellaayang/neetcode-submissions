class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        Integer[] order = new Integer[queries.length];

        for (int i = 0; i < queries.length; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> queries[a] - queries[b]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int idx : order) {
            int q = queries[idx];
            while (i < intervals.length && q >= intervals[i][0]) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int size = right - left + 1;
                minHeap.offer(new int[]{size, right});
                i++;
            }

            while (!minHeap.isEmpty() && q > minHeap.peek()[1]) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                res[idx] = minHeap.peek()[0];
            }
        }

        return res;

        
    }
}
