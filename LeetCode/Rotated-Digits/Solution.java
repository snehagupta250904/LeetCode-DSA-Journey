1class Solution {
2    private char[] s;
3    private Integer[][] f;
4
5    public int rotatedDigits(int n) {
6        s = String.valueOf(n).toCharArray();
7        f = new Integer[s.length][2];
8        return dfs(0, 0, true);
9    }
10
11    private int dfs(int i, int ok, boolean limit) {
12        if (i >= s.length) {
13            return ok;
14        }
15        if (!limit && f[i][ok] != null) {
16            return f[i][ok];
17        }
18        int up = limit ? s[i] - '0' : 9;
19        int ans = 0;
20        for (int j = 0; j <= up; ++j) {
21            if (j == 0 || j == 1 || j == 8) {
22                ans += dfs(i + 1, ok, limit && j == up);
23            } else if (j == 2 || j == 5 || j == 6 || j == 9) {
24                ans += dfs(i + 1, 1, limit && j == up);
25            }
26        }
27        if (!limit) {
28            f[i][ok] = ans;
29        }
30        return ans;
31    }
32}