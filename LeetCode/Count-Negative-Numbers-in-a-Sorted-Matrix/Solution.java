1class Solution {
2    public int countNegatives(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int ans = 0;
5        for (int i = m - 1, j = 0; i >= 0 && j < n;) {
6            if (grid[i][j] < 0) {
7                ans += n - j;
8                --i;
9            } else {
10                ++j;
11            }
12        }
13        return ans;
14    }
15}