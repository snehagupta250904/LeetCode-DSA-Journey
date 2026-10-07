1import java.util.*;
2
3class Twitter {
4
5    // userId -> set of users they follow
6    private Map<Integer, Set<Integer>> following;
7
8    // userId -> list of tweets
9    private Map<Integer, List<Tweet>> tweets;
10
11    private int time;
12
13    static class Tweet {
14        int tweetId;
15        int time;
16
17        Tweet(int tweetId, int time) {
18            this.tweetId = tweetId;
19            this.time = time;
20        }
21    }
22
23    public Twitter() {
24        following = new HashMap<>();
25        tweets = new HashMap<>();
26        time = 0;
27    }
28
29    public void postTweet(int userId, int tweetId) {
30        tweets.putIfAbsent(userId, new ArrayList<>());
31
32        tweets.get(userId).add(new Tweet(tweetId, time++));
33    }
34
35    public List<Integer> getNewsFeed(int userId) {
36
37        List<Integer> result = new ArrayList<>();
38
39        // Max heap: newest tweet first
40        PriorityQueue<Tweet> pq = new PriorityQueue<>(
41            (a, b) -> Integer.compare(b.time, a.time)
42        );
43
44        // User's own tweets
45        if (tweets.containsKey(userId)) {
46            pq.addAll(tweets.get(userId));
47        }
48
49        // Followed users' tweets
50        if (following.containsKey(userId)) {
51            for (int followee : following.get(userId)) {
52                if (tweets.containsKey(followee)) {
53                    pq.addAll(tweets.get(followee));
54                }
55            }
56        }
57
58        // Get 10 most recent tweets
59        while (!pq.isEmpty() && result.size() < 10) {
60            result.add(pq.poll().tweetId);
61        }
62
63        return result;
64    }
65
66    public void follow(int followerId, int followeeId) {
67
68        if (followerId == followeeId) {
69            return;
70        }
71
72        following.putIfAbsent(followerId, new HashSet<>());
73        following.get(followerId).add(followeeId);
74    }
75
76    public void unfollow(int followerId, int followeeId) {
77
78        if (following.containsKey(followerId)) {
79            following.get(followerId).remove(followeeId);
80        }
81    }
82}