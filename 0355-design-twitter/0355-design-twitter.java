class Twitter {
    Map<Integer, List<int[]>> userTweets;
    Map<Integer, Set<Integer>> follow;
    int timeStamp;

    public Twitter() {
        userTweets = new HashMap<>();
        follow = new HashMap<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets;
        if (userTweets.containsKey(userId)) {
            tweets = userTweets.get(userId);
        } else {
            tweets = new ArrayList<>();
        }
        
        timeStamp++;
        tweets.add(new int[]{tweetId, timeStamp});
        userTweets.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // mine
        if (userTweets.containsKey(userId)) {
            for (int[] tweet : userTweets.get(userId)) {
                heap.add(tweet);
            }
        }
        
        // follows
        if (follow.containsKey(userId)) {
            for (int followee : follow.get(userId)) {
                if (!userTweets.containsKey(followee)) {
                    continue;
                }
                for (int[] tweet : userTweets.get(followee)) {
                    heap.add(tweet);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int i = 10;
        while (i > 0 && !heap.isEmpty()) {
            int[] tweet = heap.poll();
            ans.add(tweet[0]);
            i--;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> follows;
        if (follow.containsKey(followerId)) {
            follows = follow.get(followerId);
        } else {
            follows = new HashSet<>();
        }
        
        follows.add(followeeId);
        follow.put(followerId, follows);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */