1class Solution {
2    public int trailingZeroes(int n) {
3        int ans = 0;
4        while (n > 0) {
5            n /= 5;
6            ans += n;
7        }
8        return ans;
9    }
10}