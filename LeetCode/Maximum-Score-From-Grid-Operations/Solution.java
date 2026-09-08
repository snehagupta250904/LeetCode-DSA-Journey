1class Solution {
2    public long maximumScore(int[][] grid) {
3        int n = grid.length;
4        final long inf = Long.MIN_VALUE / 2;
5        long[][] s = new long[n][n + 1];
6        for (int j = 0; j < n; ++j) {
7            for (int i = 0; i < n; ++i) {
8                s[j][i + 1] = s[j][i] + grid[i][j];
9            }
10        }
11        long[][] f = new long[n + 1][n + 1];
12        for (long[] row : f) {
13            Arrays.fill(row, inf);
14        }
15        for (int h = 0; h <= n; ++h) {
16            f[h][0] = 0;
17        }
18        for (int j = 0; j < n - 1; ++j) {
19            long[][] g = new long[n + 1][n + 1];
20            for (long[] row : g) {
21                Arrays.fill(row, inf);
22            }
23            for (int h1 = 0; h1 <= n; ++h1) {
24                long[] pre = new long[n + 2];
25                pre[0] = f[h1][0];
26                for (int h2 = 1; h2 <= n; ++h2) {
27                    pre[h2] = Math.max(pre[h2 - 1], f[h1][h2]);
28                }
29                long[] suf = new long[n + 2];
30                Arrays.fill(suf, inf);
31                for (int h2 = n; h2 >= 0; --h2) {
32                    long v = f[h1][h2] == inf ? inf : f[h1][h2] + Math.max(0, s[j][h2] - s[j][h1]);
33                    suf[h2] = Math.max(suf[h2 + 1], v);
34                }
35                for (int hp = 0; hp <= n; ++hp) {
36                    long add = Math.max(0, s[j][hp] - s[j][h1]);
37                    long v1 = pre[hp] == inf ? inf : pre[hp] + add;
38                    g[hp][h1] = Math.max(v1, suf[hp + 1]);
39                }
40            }
41            f = g;
42        }
43        long ans = 0;
44        for (int h1 = 0; h1 <= n; ++h1) {
45            for (int h2 = 0; h2 <= n; ++h2) {
46                if (f[h1][h2] != inf) {
47                    ans = Math.max(ans, f[h1][h2] + Math.max(0, s[n - 1][h2] - s[n - 1][h1]));
48                }
49            }
50        }
51        return ans;
52    }
53}