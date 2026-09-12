1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int m = dungeon.length, n = dungeon[0].length;
4        int[][] dp = new int[m + 1][n + 1];
5        for (var e : dp) {
6            Arrays.fill(e, 1 << 30);
7        }
8        dp[m][n - 1] = dp[m - 1][n] = 1;
9        for (int i = m - 1; i >= 0; --i) {
10            for (int j = n - 1; j >= 0; --j) {
11                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
12            }
13        }
14        return dp[0][0];
15    }
16}