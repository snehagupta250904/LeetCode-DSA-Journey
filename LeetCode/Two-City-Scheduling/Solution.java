1class Solution {
2    public int twoCitySchedCost(int[][] costs) {
3        Arrays.sort(costs, (a, b) -> { return a[0] - a[1] - (b[0] - b[1]); });
4        int ans = 0;
5        int n = costs.length >> 1;
6        for (int i = 0; i < n; ++i) {
7            ans += costs[i][0] + costs[i + n][1];
8        }
9        return ans;
10    }
11}