1class Solution {
2    public double frogPosition(int n, int[][] edges, int t, int target) {
3        List<Integer>[] g = new List[n + 1];
4        Arrays.setAll(g, k -> new ArrayList<>());
5        for (var e : edges) {
6            int u = e[0], v = e[1];
7            g[u].add(v);
8            g[v].add(u);
9        }
10        Deque<Pair<Integer, Double>> q = new ArrayDeque<>();
11        q.offer(new Pair<>(1, 1.0));
12        boolean[] vis = new boolean[n + 1];
13        vis[1] = true;
14        for (; !q.isEmpty() && t >= 0; --t) {
15            for (int k = q.size(); k > 0; --k) {
16                var x = q.poll();
17                int u = x.getKey();
18                double p = x.getValue();
19                int cnt = g[u].size() - (u == 1 ? 0 : 1);
20                if (u == target) {
21                    return cnt * t == 0 ? p : 0;
22                }
23                for (int v : g[u]) {
24                    if (!vis[v]) {
25                        vis[v] = true;
26                        q.offer(new Pair<>(v, p / cnt));
27                    }
28                }
29            }
30        }
31        return 0;
32    }
33}