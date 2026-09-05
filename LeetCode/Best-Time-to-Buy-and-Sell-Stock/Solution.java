1class Solution {
2    public int maxProfit(int[] prices) {
3       int ans = 0, mi = prices[0];
4        for (int v : prices) {
5            ans = Math.max(ans, v - mi);
6            mi = Math.min(mi, v);
7        }
8        return ans; 
9    }
10}