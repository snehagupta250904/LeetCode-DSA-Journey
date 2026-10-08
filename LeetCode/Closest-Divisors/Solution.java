1class Solution {
2    public int[] closestDivisors(int num) {
3        int[] a = f(num + 1);
4        int[] b = f(num + 2);
5        return Math.abs(a[0] - a[1]) < Math.abs(b[0] - b[1]) ? a : b;
6    }
7
8    private int[] f(int x) {
9        for (int i = (int) Math.sqrt(x);; --i) {
10            if (x % i == 0) {
11                return new int[] {i, x / i};
12            }
13        }
14    }
15}