1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        int m = s1.length(), n = s2.length();
4        if (m + n != s3.length()) {
5            return false;
6        }
7        boolean[][] f = new boolean[m + 1][n + 1];
8        f[0][0] = true;
9        for (int i = 0; i <= m; ++i) {
10            for (int j = 0; j <= n; ++j) {
11                int k = i + j - 1;
12                if (i > 0 && s1.charAt(i - 1) == s3.charAt(k)) {
13                    f[i][j] = f[i - 1][j];
14                }
15                if (j > 0 && s2.charAt(j - 1) == s3.charAt(k)) {
16                    f[i][j] |= f[i][j - 1];
17                }
18            }
19        }
20        return f[m][n];
21    }
22}