1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4        int[][] f = new int[k + 1][2];
5        for (int j = 1; j <= k; ++j) {
6            f[j][1] = -prices[0];
7        }
8        for (int i = 1; i < n; ++i) {
9            for (int j = k; j > 0; --j) {
10                f[j][0] = Math.max(f[j][1] + prices[i], f[j][0]);
11                f[j][1] = Math.max(f[j - 1][0] - prices[i], f[j][1]);
12            }
13        }
14        return f[k][0];
15    }
16}