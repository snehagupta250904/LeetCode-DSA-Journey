1class Solution {
2    private List<String> board;
3    private int n;
4    private int[][] f;
5    private int[][] g;
6    private final int mod = (int) 1e9 + 7;
7
8    public int[] pathsWithMaxScore(List<String> board) {
9        n = board.size();
10        this.board = board;
11        f = new int[n][n];
12        g = new int[n][n];
13        for (var e : f) {
14            Arrays.fill(e, -1);
15        }
16        f[n - 1][n - 1] = 0;
17        g[n - 1][n - 1] = 1;
18        for (int i = n - 1; i >= 0; --i) {
19            for (int j = n - 1; j >= 0; --j) {
20                update(i, j, i + 1, j);
21                update(i, j, i, j + 1);
22                update(i, j, i + 1, j + 1);
23                if (f[i][j] != -1) {
24                    char c = board.get(i).charAt(j);
25                    if (c >= '0' && c <= '9') {
26                        f[i][j] += (c - '0');
27                    }
28                }
29            }
30        }
31        int[] ans = new int[2];
32        if (f[0][0] != -1) {
33            ans[0] = f[0][0];
34            ans[1] = g[0][0];
35        }
36        return ans;
37    }
38
39    private void update(int i, int j, int x, int y) {
40        if (x >= n || y >= n || f[x][y] == -1 || board.get(i).charAt(j) == 'X'
41            || board.get(i).charAt(j) == 'S') {
42            return;
43        }
44        if (f[x][y] > f[i][j]) {
45            f[i][j] = f[x][y];
46            g[i][j] = g[x][y];
47        } else if (f[x][y] == f[i][j]) {
48            g[i][j] = (g[i][j] + g[x][y]) % mod;
49        }
50    }
51}