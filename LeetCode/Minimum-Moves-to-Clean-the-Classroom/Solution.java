1class Solution {
2    public int minMoves(String[] classroom, int energy) {
3        int m = classroom.length, n = classroom[0].length();
4        int[][] d = new int[m][n];
5        int x = 0, y = 0, cnt = 0;
6        for (int i = 0; i < m; i++) {
7            String row = classroom[i];
8            for (int j = 0; j < n; j++) {
9                char c = row.charAt(j);
10                if (c == 'S') {
11                    x = i;
12                    y = j;
13                } else if (c == 'L') {
14                    d[i][j] = cnt;
15                    cnt++;
16                }
17            }
18        }
19        if (cnt == 0) {
20            return 0;
21        }
22        boolean[][][][] vis = new boolean[m][n][energy + 1][1 << cnt];
23        List<int[]> q = new ArrayList<>();
24        q.add(new int[] {x, y, energy, (1 << cnt) - 1});
25        vis[x][y][energy][(1 << cnt) - 1] = true;
26        int[] dirs = {-1, 0, 1, 0, -1};
27        int ans = 0;
28        while (!q.isEmpty()) {
29            List<int[]> t = q;
30            q = new ArrayList<>();
31            for (int[] state : t) {
32                int i = state[0], j = state[1], curEnergy = state[2], mask = state[3];
33                if (mask == 0) {
34                    return ans;
35                }
36                if (curEnergy <= 0) {
37                    continue;
38                }
39                for (int k = 0; k < 4; k++) {
40                    int nx = i + dirs[k], ny = j + dirs[k + 1];
41                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && classroom[nx].charAt(ny) != 'X') {
42                        int nxtEnergy = classroom[nx].charAt(ny) == 'R' ? energy : curEnergy - 1;
43                        int nxtMask = mask;
44                        if (classroom[nx].charAt(ny) == 'L') {
45                            nxtMask &= ~(1 << d[nx][ny]);
46                        }
47                        if (!vis[nx][ny][nxtEnergy][nxtMask]) {
48                            vis[nx][ny][nxtEnergy][nxtMask] = true;
49                            q.add(new int[] {nx, ny, nxtEnergy, nxtMask});
50                        }
51                    }
52                }
53            }
54            ans++;
55        }
56        return -1;
57    }
58}