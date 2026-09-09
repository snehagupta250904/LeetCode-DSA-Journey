1class Solution {
2    private List<int[]>[] g;
3    private boolean[] vis;
4    private int ans = 1 << 30;
5
6    public int minScore(int n, int[][] roads) {
7        g = new List[n];
8        vis = new boolean[n];
9        Arrays.setAll(g, k -> new ArrayList<>());
10        for (var e : roads) {
11            int a = e[0] - 1, b = e[1] - 1, d = e[2];
12            g[a].add(new int[] {b, d});
13            g[b].add(new int[] {a, d});
14        }
15        dfs(0);
16        return ans;
17    }
18
19    private void dfs(int i) {
20        for (var nxt : g[i]) {
21            int j = nxt[0], d = nxt[1];
22            ans = Math.min(ans, d);
23            if (!vis[j]) {
24                vis[j] = true;
25                dfs(j);
26            }
27        }
28    }
29}