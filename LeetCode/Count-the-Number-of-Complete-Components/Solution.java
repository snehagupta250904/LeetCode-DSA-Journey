1class Solution {
2    private List<Integer>[] g;
3    private boolean[] vis;
4
5    public int countCompleteComponents(int n, int[][] edges) {
6        g = new List[n];
7        vis = new boolean[n];
8        Arrays.setAll(g, k -> new ArrayList<>());
9        for (int[] e : edges) {
10            int a = e[0], b = e[1];
11            g[a].add(b);
12            g[b].add(a);
13        }
14        int ans = 0;
15        for (int i = 0; i < n; ++i) {
16            if (!vis[i]) {
17                int[] t = dfs(i);
18                if (t[0] * (t[0] - 1) == t[1]) {
19                    ++ans;
20                }
21            }
22        }
23        return ans;
24    }
25
26    private int[] dfs(int i) {
27        vis[i] = true;
28        int x = 1, y = g[i].size();
29        for (int j : g[i]) {
30            if (!vis[j]) {
31                int[] t = dfs(j);
32                x += t[0];
33                y += t[1];
34            }
35        }
36        return new int[] {x, y};
37    }
38}