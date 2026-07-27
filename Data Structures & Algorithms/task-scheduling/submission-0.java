class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int count : counts) {
            if (count != 0) {
                maxHeap.offer(count);

            }
            
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int c = maxHeap.poll();
                c--;
                if (c > 0) {
                    queue.add(new int[]{c, time + n});
                }
            } else {
                time = queue.peek()[1];
            }

            if (!queue.isEmpty()) {
                if (time == queue.peek()[1]) {
                    maxHeap.add(queue.poll()[0]);
                }
            }

        }

        return time;
        
    }
}
