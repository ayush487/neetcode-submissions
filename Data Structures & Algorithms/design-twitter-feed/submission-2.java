class Twitter {

    private class Tweet {
        private static int count = 0;
        int userId;
        int tweetId;
        int timestamp;

        Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = ++count;
        }

        @Override
        public String toString() {
            return "Tweet{" +
                    "userId=" + userId +
                    ", tweetId=" + tweetId +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }

    private Map<Integer, Set<Integer>> followings;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        this.followings = new HashMap<>();
        this.tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        if (tweets.containsKey(userId)) {
            tweets.get(userId).add(tweet);
        } else {
            List<Tweet> list = new ArrayList<>();
            list.add(tweet);
            tweets.put(userId, list);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> userFollowers = followings.computeIfAbsent(userId, u -> new HashSet<>());
        userFollowers.add(userId);
        PriorityQueue<Tweet> newsFeed = new PriorityQueue<>((t1, t2) ->
                t1.timestamp - t2.timestamp);
        for (int f : userFollowers) {
            if (!tweets.containsKey(f)) {
                continue;
            }
            List<Tweet> userTweets = tweets.get(f);
            if (userTweets.size() > 10) {
                int tc = userTweets.size() - 10;
                for (int i = userTweets.size() - 1; i >= tc; i--) {
                    addTweet(newsFeed, userTweets.get(i), 10);
                }
            } else {
                for (int i = userTweets.size() - 1; i >= 0; i--) {
                    addTweet(newsFeed, userTweets.get(i), 10);
                }
            }
        }
        int tweetCount = newsFeed.size();
        List<Integer> res = new ArrayList<>(Collections.nCopies(tweetCount, null));
        for (int i=tweetCount-1;i>=0;i--) {
            res.set(i, newsFeed.poll().tweetId);
        }
        return res;
    }

    private void addTweet(PriorityQueue<Tweet> heap, Tweet t, int sizeLimit) {
        heap.offer(t);
        if (heap.size() > sizeLimit) heap.poll();
    }

    public void follow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followings.put(followerId, set);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).remove(followeeId);
        }
    }
}
