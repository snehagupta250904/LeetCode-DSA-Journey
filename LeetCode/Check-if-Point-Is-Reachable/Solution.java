1class Solution {
2    public boolean isReachable(int targetX, int targetY) {
3        int x = gcd(targetX, targetY);
4        return (x & (x - 1)) == 0;
5    }
6
7    private int gcd(int a, int b) {
8        return b == 0 ? a : gcd(b, a % b);
9    }
10}