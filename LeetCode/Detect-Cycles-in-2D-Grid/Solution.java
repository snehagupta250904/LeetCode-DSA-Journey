1class Solution {
2
3    public boolean containsCycle(char[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6
7        boolean[][] visited = new boolean[m][n];
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11
12                if (!visited[i][j]) {
13                    if (dfs(grid, visited, i, j, -1, -1)) {
14                        return true;
15                    }
16                }
17            }
18        }
19
20        return false;
21    }
22
23    private boolean dfs(char[][] grid, boolean[][] visited,
24                         int row, int col, int parentRow, int parentCol) {
25
26        int m = grid.length;
27        int n = grid[0].length;
28
29        visited[row][col] = true;
30
31        int[][] directions = {
32            {-1, 0},  // up
33            {1, 0},   // down
34            {0, -1},  // left
35            {0, 1}    // right
36        };
37
38        for (int[] dir : directions) {
39
40            int newRow = row + dir[0];
41            int newCol = col + dir[1];
42
43            // Outside grid
44            if (newRow < 0 || newRow >= m ||
45                newCol < 0 || newCol >= n) {
46                continue;
47            }
48
49            // Different character
50            if (grid[newRow][newCol] != grid[row][col]) {
51                continue;
52            }
53
54            // Don't go back to the cell we came from
55            if (newRow == parentRow && newCol == parentCol) {
56                continue;
57            }
58
59            // Already visited -> cycle found
60            if (visited[newRow][newCol]) {
61                return true;
62            }
63
64            // Continue DFS
65            if (dfs(grid, visited, newRow, newCol, row, col)) {
66                return true;
67            }
68        }
69
70        return false;
71    }
72}