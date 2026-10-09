1class Solution {
2    public int[][] rangeAddQueries(int n, int[][] queries) {
3        int[][] mat = new int[n][n];
4        for (var q : queries) {
5            int x1 = q[0], y1 = q[1], x2 = q[2], y2 = q[3];
6            mat[x1][y1]++;
7            if (x2 + 1 < n) {
8                mat[x2 + 1][y1]--;
9            }
10            if (y2 + 1 < n) {
11                mat[x1][y2 + 1]--;
12            }
13            if (x2 + 1 < n && y2 + 1 < n) {
14                mat[x2 + 1][y2 + 1]++;
15            }
16        }
17        for (int i = 0; i < n; ++i) {
18            for (int j = 0; j < n; ++j) {
19                if (i > 0) {
20                    mat[i][j] += mat[i - 1][j];
21                }
22                if (j > 0) {
23                    mat[i][j] += mat[i][j - 1];
24                }
25                if (i > 0 && j > 0) {
26                    mat[i][j] -= mat[i - 1][j - 1];
27                }
28            }
29        }
30        return mat;
31    }
32}