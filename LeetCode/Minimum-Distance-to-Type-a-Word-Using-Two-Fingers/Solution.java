1class Solution {
2    public int minimumDistance(String word) {
3        int n = word.length();
4        final int inf = 1 << 30;
5        int[][][] f = new int[n][26][26];
6        for (int[][] g : f) {
7            for (int[] h : g) {
8                Arrays.fill(h, inf);
9            }
10        }
11        for (int j = 0; j < 26; ++j) {
12            f[0][word.charAt(0) - 'A'][j] = 0;
13            f[0][j][word.charAt(0) - 'A'] = 0;
14        }
15        for (int i = 1; i < n; ++i) {
16            int a = word.charAt(i - 1) - 'A';
17            int b = word.charAt(i) - 'A';
18            int d = dist(a, b);
19            for (int j = 0; j < 26; ++j) {
20                f[i][b][j] = Math.min(f[i][b][j], f[i - 1][a][j] + d);
21                f[i][j][b] = Math.min(f[i][j][b], f[i - 1][j][a] + d);
22                if (j == a) {
23                    for (int k = 0; k < 26; ++k) {
24                        int t = dist(k, b);
25                        f[i][b][j] = Math.min(f[i][b][j], f[i - 1][k][a] + t);
26                        f[i][j][b] = Math.min(f[i][j][b], f[i - 1][a][k] + t);
27                    }
28                }
29            }
30        }
31        int ans = inf;
32        for (int j = 0; j < 26; ++j) {
33            ans = Math.min(ans, f[n - 1][j][word.charAt(n - 1) - 'A']);
34            ans = Math.min(ans, f[n - 1][word.charAt(n - 1) - 'A'][j]);
35        }
36        return ans;
37    }
38
39    private int dist(int a, int b) {
40        int x1 = a / 6, y1 = a % 6;
41        int x2 = b / 6, y2 = b % 6;
42        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
43    }
44}