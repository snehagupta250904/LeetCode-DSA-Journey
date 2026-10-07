1class Solution {
2    public int[] countBits(int n) {
3        int[] ans = new int[n + 1];
4        for (int i = 1; i <= n; ++i) {
5            ans[i] = ans[i & (i - 1)] + 1;
6        }
7        return ans;
8    }
9}