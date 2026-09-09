1class Solution {
2
3    public int maximumSafenessFactor(List<List<Integer>> grid) {
4        int n = grid.size();
5
6        // dist[r][c] = Manhattan distance to the nearest thief
7        int[][] dist = new int[n][n];
8        for (int[] row : dist) {
9            Arrays.fill(row, -1);
10        }
11
12        // Multi-source BFS starting from all thieves
13        Queue<int[]> queue = new ArrayDeque<>();
14
15        for (int r = 0; r < n; r++) {
16            for (int c = 0; c < n; c++) {
17                if (grid.get(r).get(c) == 1) {
18                    dist[r][c] = 0;
19                    queue.offer(new int[]{r, c});
20                }
21            }
22        }
23
24        int[][] dirs = {
25            {1, 0},
26            {-1, 0},
27            {0, 1},
28            {0, -1}
29        };
30
31        while (!queue.isEmpty()) {
32            int[] cur = queue.poll();
33            int r = cur[0];
34            int c = cur[1];
35
36            for (int[] d : dirs) {
37                int nr = r + d[0];
38                int nc = c + d[1];
39
40                if (nr >= 0 && nr < n && nc >= 0 && nc < n
41                        && dist[nr][nc] == -1) {
42
43                    dist[nr][nc] = dist[r][c] + 1;
44                    queue.offer(new int[]{nr, nc});
45                }
46            }
47        }
48
49        // Binary search for maximum possible safeness factor
50        int low = 0;
51        int high = 2 * n; // Maximum Manhattan distance is 2n - 2
52
53        while (low < high) {
54            int mid = low + (high - low + 1) / 2;
55
56            if (canReach(dist, n, mid)) {
57                low = mid;
58            } else {
59                high = mid - 1;
60            }
61        }
62
63        return low;
64    }
65
66    private boolean canReach(int[][] dist, int n, int safe) {
67
68        // Starting cell itself must satisfy the safeness requirement
69        if (dist[0][0] < safe) {
70            return false;
71        }
72
73        boolean[][] visited = new boolean[n][n];
74        Queue<int[]> queue = new ArrayDeque<>();
75
76        queue.offer(new int[]{0, 0});
77        visited[0][0] = true;
78
79        int[][] dirs = {
80            {1, 0},
81            {-1, 0},
82            {0, 1},
83            {0, -1}
84        };
85
86        while (!queue.isEmpty()) {
87            int[] cur = queue.poll();
88            int r = cur[0];
89            int c = cur[1];
90
91            if (r == n - 1 && c == n - 1) {
92                return true;
93            }
94
95            for (int[] d : dirs) {
96                int nr = r + d[0];
97                int nc = c + d[1];
98
99                if (nr >= 0 && nr < n && nc >= 0 && nc < n
100                        && !visited[nr][nc]
101                        && dist[nr][nc] >= safe) {
102
103                    visited[nr][nc] = true;
104                    queue.offer(new int[]{nr, nc});
105                }
106            }
107        }
108
109        return false;
110    }
111}
112