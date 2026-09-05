1class Solution {
2    public int maxProfit(int[] prices) {
3        int ans = 0;
4        for (int i = 1; i < prices.length; ++i) {
5            ans += Math.max(0, prices[i] - prices[i - 1]);
6        }
7        return ans;
8    }
9}