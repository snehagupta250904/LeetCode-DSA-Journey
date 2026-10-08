1class Solution {
2    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
3        Deque<int[]> q = new ArrayDeque<>();
4        q.offer(new int[] {rCenter, cCenter});
5        boolean[][] vis = new boolean[rows][cols];
6        vis[rCenter][cCenter] = true;
7        int[][] ans = new int[rows * cols][2];
8        int[] dirs = {-1, 0, 1, 0, -1};
9        int idx = 0;
10        while (!q.isEmpty()) {
11            for (int n = q.size(); n > 0; --n) {
12                var p = q.poll();
13                ans[idx++] = p;
14                for (int k = 0; k < 4; ++k) {
15                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
16                    if (x >= 0 && x < rows && y >= 0 && y < cols && !vis[x][y]) {
17                        vis[x][y] = true;
18                        q.offer(new int[] {x, y});
19                    }
20                }
21            }
22        }
23        return ans;
24    }
25}