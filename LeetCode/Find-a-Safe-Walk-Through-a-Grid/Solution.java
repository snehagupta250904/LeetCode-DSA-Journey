1class Solution {
2    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
3        int m = grid.size();
4        int n = grid.get(0).size();
5        int[][] dist = new int[m][n];
6        for (int[] row : dist) {
7            Arrays.fill(row, Integer.MAX_VALUE);
8        }
9        dist[0][0] = grid.get(0).get(0);
10        Deque<int[]> q = new ArrayDeque<>();
11        q.offer(new int[] {0, 0});
12        final int[] dirs = {-1, 0, 1, 0, -1};
13        while (!q.isEmpty()) {
14            int[] curr = q.poll();
15            int x = curr[0], y = curr[1];
16            for (int i = 0; i < 4; i++) {
17                int nx = x + dirs[i];
18                int ny = y + dirs[i + 1];
19                if (nx >= 0 && nx < m && ny >= 0 && ny < n
20                    && dist[nx][ny] > dist[x][y] + grid.get(nx).get(ny)) {
21                    dist[nx][ny] = dist[x][y] + grid.get(nx).get(ny);
22                    q.offer(new int[] {nx, ny});
23                }
24            }
25        }
26        return dist[m - 1][n - 1] < health;
27    }
28}