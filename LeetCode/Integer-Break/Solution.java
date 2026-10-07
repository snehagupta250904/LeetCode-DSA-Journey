1class Solution {
2    public int integerBreak(int n) {
3        if (n < 4) {
4            return n - 1;
5        }
6        if (n % 3 == 0) {
7            return (int) Math.pow(3, n / 3);
8        }
9        if (n % 3 == 1) {
10            return (int) Math.pow(3, n / 3 - 1) * 4;
11        }
12        return (int) Math.pow(3, n / 3) * 2;
13    }
14}