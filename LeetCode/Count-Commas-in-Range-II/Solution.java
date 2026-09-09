1class Solution {
2    public long countCommas(long n) {
3        long ans = 0;
4        for (long x = 1000; x <= n; x *= 1000) {
5            ans += n - x + 1;
6        }
7        return ans;
8    }
9}