class MedianFinder {
    PriorityQueue<Integer> maxHeap; // small heap
    PriorityQueue<Integer> minHeap; // large heap

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if ((maxHeap.size() - minHeap.size() > 1) || (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            int cur = maxHeap.poll();
            minHeap.add(cur);
        }

        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        
    }
}
