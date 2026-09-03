1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        int m = matrix.length, n = matrix[0].length;
4        int[] dirs = {0, 1, 0, -1, 0};
5        int i = 0, j = 0, k = 0;
6        List<Integer> ans = new ArrayList<>();
7        boolean[][] vis = new boolean[m][n];
8        for (int h = m * n; h > 0; --h) {
9            ans.add(matrix[i][j]);
10            vis[i][j] = true;
11            int x = i + dirs[k], y = j + dirs[k + 1];
12            if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) {
13                k = (k + 1) % 4;
14            }
15            i += dirs[k];
16            j += dirs[k + 1];
17        }
18        return ans;
19    }
20}