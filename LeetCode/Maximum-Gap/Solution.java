1class Solution {
2    public int maximumGap(int[] nums) {
3        int n = nums.length;
4        if (n < 2) {
5            return 0;
6        }
7        int inf = 0x3f3f3f3f;
8        int mi = inf, mx = -inf;
9        for (int v : nums) {
10            mi = Math.min(mi, v);
11            mx = Math.max(mx, v);
12        }
13        int bucketSize = Math.max(1, (mx - mi) / (n - 1));
14        int bucketCount = (mx - mi) / bucketSize + 1;
15        int[][] buckets = new int[bucketCount][2];
16        for (var bucket : buckets) {
17            bucket[0] = inf;
18            bucket[1] = -inf;
19        }
20        for (int v : nums) {
21            int i = (v - mi) / bucketSize;
22            buckets[i][0] = Math.min(buckets[i][0], v);
23            buckets[i][1] = Math.max(buckets[i][1], v);
24        }
25        int prev = inf;
26        int ans = 0;
27        for (var bucket : buckets) {
28            if (bucket[0] > bucket[1]) {
29                continue;
30            }
31            ans = Math.max(ans, bucket[0] - prev);
32            prev = bucket[1];
33        }
34        return ans;
35    }
36}