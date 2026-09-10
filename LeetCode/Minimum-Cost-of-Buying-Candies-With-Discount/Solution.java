1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4        int ans = 0;
5        for (int i = cost.length - 1; i >= 0; i -= 3) {
6            ans += cost[i];
7            if (i > 0) {
8                ans += cost[i - 1];
9            }
10        }
11        return ans;
12    }
13}