1 class Solution {
2    public int uniquePaths(int m, int n) {
3        int[] f = new int[n];
4        Arrays.fill(f, 1);
5        for (int i = 1; i < m; ++i) {
6            for (int j = 1; j < n; ++j) {
7                f[j] += f[j - 1];
8            }
9        }
10        return f[n - 1];
11    }
12} 