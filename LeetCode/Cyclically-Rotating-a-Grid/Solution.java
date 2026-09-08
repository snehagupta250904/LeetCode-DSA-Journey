1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int s1 = 0, e1 = 0;
5        int s2 = m - 1, e2 = n - 1;
6        while (s1 <= s2 && e1 <= e2) {
7            rotate(grid, s1++, e1++, s2--, e2--, k);
8        }
9        return grid;
10    }
11
12    private void rotate(int[][] grid, int s1, int e1, int s2, int e2, int k) {
13        List<Integer> t = new ArrayList<>();
14        for (int j = e2; j > e1; --j) {
15            t.add(grid[s1][j]);
16        }
17        for (int i = s1; i < s2; ++i) {
18            t.add(grid[i][e1]);
19        }
20        for (int j = e1; j < e2; ++j) {
21            t.add(grid[s2][j]);
22        }
23        for (int i = s2; i > s1; --i) {
24            t.add(grid[i][e2]);
25        }
26        int n = t.size();
27        k %= n;
28        if (k == 0) {
29            return;
30        }
31        k = n - k;
32        for (int j = e2; j > e1; --j) {
33            grid[s1][j] = t.get(k);
34            k = (k + 1) % n;
35        }
36        for (int i = s1; i < s2; ++i) {
37            grid[i][e1] = t.get(k);
38            k = (k + 1) % n;
39        }
40        for (int j = e1; j < e2; ++j) {
41            grid[s2][j] = t.get(k);
42            k = (k + 1) % n;
43        }
44        for (int i = s2; i > s1; --i) {
45            grid[i][e2] = t.get(k);
46            k = (k + 1) % n;
47        }
48    }
49}