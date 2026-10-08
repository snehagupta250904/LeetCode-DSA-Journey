1class Solution {
2    public int countOrders(int n) {
3        final int mod = (int) 1e9 + 7;
4        long f = 1;
5        for (int i = 2; i <= n; ++i) {
6            f = f * i * (2 * i - 1) % mod;
7        }
8        return (int) f;
9    }
10}