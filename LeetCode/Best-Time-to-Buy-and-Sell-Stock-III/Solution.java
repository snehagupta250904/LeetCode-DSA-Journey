1class Solution {
2    public int maxProfit(int[] prices) {
3        int buy1 = Integer.MIN_VALUE, sell1 = 0;
4        int buy2 = Integer.MIN_VALUE, sell2 = 0;
5
6        for (int price : prices) {
7            buy1 = Math.max(buy1, -price);
8            sell1 = Math.max(sell1, buy1 + price);
9
10            buy2 = Math.max(buy2, sell1 - price);
11            sell2 = Math.max(sell2, buy2 + price);
12        }
13
14        return sell2;
15    }
16}