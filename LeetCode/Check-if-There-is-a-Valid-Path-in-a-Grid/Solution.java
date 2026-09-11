1class Solution {
2    private int[] p;
3    private int[][] grid;
4    private int m;
5    private int n;
6
7    public boolean hasValidPath(int[][] grid) {
8        this.grid = grid;
9        m = grid.length;
10        n = grid[0].length;
11        p = new int[m * n];
12        for (int i = 0; i < p.length; ++i) {
13            p[i] = i;
14        }
15        for (int i = 0; i < m; ++i) {
16            for (int j = 0; j < n; ++j) {
17                int e = grid[i][j];
18                if (e == 1) {
19                    left(i, j);
20                    right(i, j);
21                } else if (e == 2) {
22                    up(i, j);
23                    down(i, j);
24                } else if (e == 3) {
25                    left(i, j);
26                    down(i, j);
27                } else if (e == 4) {
28                    right(i, j);
29                    down(i, j);
30                } else if (e == 5) {
31                    left(i, j);
32                    up(i, j);
33                } else {
34                    right(i, j);
35                    up(i, j);
36                }
37            }
38        }
39        return find(0) == find(m * n - 1);
40    }
41
42    private int find(int x) {
43        if (p[x] != x) {
44            p[x] = find(p[x]);
45        }
46        return p[x];
47    }
48
49    private void left(int i, int j) {
50        if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
51            p[find(i * n + j)] = find(i * n + j - 1);
52        }
53    }
54
55    private void right(int i, int j) {
56        if (j < n - 1 && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
57            p[find(i * n + j)] = find(i * n + j + 1);
58        }
59    }
60
61    private void up(int i, int j) {
62        if (i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
63            p[find(i * n + j)] = find((i - 1) * n + j);
64        }
65    }
66
67    private void down(int i, int j) {
68        if (i < m - 1 && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
69            p[find(i * n + j)] = find((i + 1) * n + j);
70        }
71    }
72}