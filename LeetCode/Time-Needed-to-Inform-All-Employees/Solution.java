1class Solution {
2    private List<Integer>[] g;
3    private int[] informTime;
4
5    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
6        g = new List[n];
7        Arrays.setAll(g, k -> new ArrayList<>());
8        this.informTime = informTime;
9        for (int i = 0; i < n; ++i) {
10            if (manager[i] >= 0) {
11                g[manager[i]].add(i);
12            }
13        }
14        return dfs(headID);
15    }
16
17    private int dfs(int i) {
18        int ans = 0;
19        for (int j : g[i]) {
20            ans = Math.max(ans, dfs(j) + informTime[i]);
21        }
22        return ans;
23    }
24}