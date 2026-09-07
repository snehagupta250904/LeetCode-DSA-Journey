1class Solution {
2    private long[][] f;
3    private List<Integer> robot;
4    private int[][] factory;
5
6    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
7        Collections.sort(robot);
8        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
9        this.robot = robot;
10        this.factory = factory;
11        f = new long[robot.size()][factory.length];
12        return dfs(0, 0);
13    }
14
15    private long dfs(int i, int j) {
16        if (i == robot.size()) {
17            return 0;
18        }
19        if (j == factory.length) {
20            return Long.MAX_VALUE / 1000;
21        }
22        if (f[i][j] != 0) {
23            return f[i][j];
24        }
25        long ans = dfs(i, j + 1);
26        long t = 0;
27        for (int k = 0; k < factory[j][1]; ++k) {
28            if (i + k == robot.size()) {
29                break;
30            }
31            t += Math.abs(robot.get(i + k) - factory[j][0]);
32            ans = Math.min(ans, t + dfs(i + k + 1, j + 1));
33        }
34        f[i][j] = ans;
35        return ans;
36    }
37}