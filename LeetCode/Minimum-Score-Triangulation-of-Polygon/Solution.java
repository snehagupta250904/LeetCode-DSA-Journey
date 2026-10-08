1class Solution {
2    public int minScoreTriangulation(int[] values) {
3        int n = values.length;
4        int[][] f = new int[n][n];
5        for (int l = 3; l <= n; ++l) {
6            for (int i = 0; i + l - 1 < n; ++i) {
7                int j = i + l - 1;
8                f[i][j] = 1 << 30;
9                for (int k = i + 1; k < j; ++k) {
10                    f[i][j]
11                        = Math.min(f[i][j], f[i][k] + f[k][j] + values[i] * values[k] * values[j]);
12                }
13            }
14        }
15        return f[0][n - 1];
16    }
17}