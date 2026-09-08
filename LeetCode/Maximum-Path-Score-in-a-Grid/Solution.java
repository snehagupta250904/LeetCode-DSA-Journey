1class Solution {
2    private int[][] grid;
3    private Integer[][][] f;
4    private final int inf = 1 << 30;
5
6    public int maxPathScore(int[][] grid, int k) {
7        this.grid = grid;
8        int m = grid.length;
9        int n = grid[0].length;
10        f = new Integer[m][n][k + 1];
11        int ans = dfs(m - 1, n - 1, k);
12        return ans < 0 ? -1 : ans;
13    }
14
15    private int dfs(int i, int j, int k) {
16        if (i < 0 || j < 0 || k < 0) {
17            return -inf;
18        }
19        if (i == 0 && j == 0) {
20            return 0;
21        }
22        if (f[i][j][k] != null) {
23            return f[i][j][k];
24        }
25        int res = grid[i][j];
26        int nk = k;
27        if (grid[i][j] > 0) {
28            --nk;
29        }
30        int a = dfs(i - 1, j, nk);
31        int b = dfs(i, j - 1, nk);
32        res += Math.max(a, b);
33        f[i][j][k] = res;
34        return res;
35    }
36}