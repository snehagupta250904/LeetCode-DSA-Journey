1class Solution {
2    public int maximumLength(int[] nums) {
3        Map<Long, Integer> cnt = new HashMap<>();
4        for (int x : nums) {
5            cnt.merge((long) x, 1, Integer::sum);
6        }
7        Integer t = cnt.remove(1L);
8        int ans = t == null ? 0 : t - (t % 2 ^ 1);
9        for (long x : cnt.keySet()) {
10            t = 0;
11            while (cnt.getOrDefault(x, 0) > 1) {
12                x = x * x;
13                t += 2;
14            }
15            t += cnt.getOrDefault(x, -1);
16            ans = Math.max(ans, t);
17        }
18        return ans;
19    }
20}