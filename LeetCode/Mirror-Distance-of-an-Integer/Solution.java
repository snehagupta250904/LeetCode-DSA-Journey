1class Solution {
2    public int mirrorDistance(int n) {
3        return Math.abs(n - reverse(n));
4    }
5
6    private int reverse(int x) {
7        int y = 0;
8        for (; x > 0; x /= 10) {
9            y = y * 10 + x % 10;
10        }
11        return y;
12    }
13}