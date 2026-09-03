1class Solution {
2    private int n;
3    private int ans;
4    private boolean[] cols = new boolean[10];
5    private boolean[] dg = new boolean[20];
6    private boolean[] udg = new boolean[20];
7
8    public int totalNQueens(int n) {
9        this.n = n;
10        dfs(0);
11        return ans;
12    }
13
14    private void dfs(int i) {
15        if (i == n) {
16            ++ans;
17            return;
18        }
19        for (int j = 0; j < n; ++j) {
20            int a = i + j, b = i - j + n;
21            if (cols[j] || dg[a] || udg[b]) {
22                continue;
23            }
24            cols[j] = true;
25            dg[a] = true;
26            udg[b] = true;
27            dfs(i + 1);
28            cols[j] = false;
29            dg[a] = false;
30            udg[b] = false;
31        }
32    }
33}