class Twitter {
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    private int timeStamp;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        timeStamp = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }

        List<int[]> tweets = tweetMap.get(userId);
        tweets.add(new int[]{timeStamp, tweetId});
        timeStamp++; 
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }

        followMap.get(userId).add(userId);

        Set<Integer> followeeIds = followMap.get(userId);
        for (int followeeId : followeeIds) {
            if (!tweetMap.containsKey(followeeId)) {
                continue;
            }
            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size() - 1;
            int[] tweetLatest = tweets.get(index);
            maxHeap.offer(new int[] {tweetLatest[0], tweetLatest[1], followeeId, index});
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] cur = maxHeap.poll();
            res.add(cur[1]);
            int followeeId = cur[2];
            int index = cur[3];
            if (index > 0) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int[] tweetLatest = tweets.get(index - 1);
                maxHeap.offer(new int[] {tweetLatest[0], tweetLatest[1], followeeId, index - 1});
            }
        }

        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }

        Set<Integer> followees = followMap.get(followerId);
        followees.add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}
