1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length;
4        Map<Integer, List<Integer>> g = new HashMap<>();
5        for (int i = 0; i < n; ++i) {
6            g.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
7        }
8        final int inf = 1 << 30;
9        int ans = inf;
10        for (var ls : g.values()) {
11            int m = ls.size();
12            for (int h = 0; h < m - 2; ++h) {
13                int i = ls.get(h);
14                int k = ls.get(h + 2);
15                int t = (k - i) * 2;
16                ans = Math.min(ans, t);
17            }
18        }
19        return ans == inf ? -1 : ans;
20    }
21}