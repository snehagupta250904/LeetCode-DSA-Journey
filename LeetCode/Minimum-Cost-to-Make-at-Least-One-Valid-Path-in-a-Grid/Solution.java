1class Solution {
2    public int minCost(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        boolean[][] vis = new boolean[m][n];
5        Deque<int[]> q = new ArrayDeque<>();
6        q.offer(new int[] {0, 0, 0});
7        int[][] dirs = { {0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
8        while (!q.isEmpty()) {
9            int[] p = q.poll();
10            int i = p[0], j = p[1], d = p[2];
11            if (i == m - 1 && j == n - 1) {
12                return d;
13            }
14            if (vis[i][j]) {
15                continue;
16            }
17            vis[i][j] = true;
18            for (int k = 1; k <= 4; ++k) {
19                int x = i + dirs[k][0], y = j + dirs[k][1];
20                if (x >= 0 && x < m && y >= 0 && y < n) {
21                    if (grid[i][j] == k) {
22                        q.offerFirst(new int[] {x, y, d});
23                    } else {
24                        q.offer(new int[] {x, y, d + 1});
25                    }
26                }
27            }
28        }
29        return -1;
30    }
31}