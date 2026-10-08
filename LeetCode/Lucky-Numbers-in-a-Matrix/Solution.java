1class Solution {
2    public List<Integer> luckyNumbers(int[][] matrix) {
3        int m = matrix.length, n = matrix[0].length;
4        int[] rows = new int[m];
5        int[] cols = new int[n];
6        Arrays.fill(rows, 1 << 30);
7        for (int i = 0; i < m; ++i) {
8            for (int j = 0; j < n; ++j) {
9                rows[i] = Math.min(rows[i], matrix[i][j]);
10                cols[j] = Math.max(cols[j], matrix[i][j]);
11            }
12        }
13        List<Integer> ans = new ArrayList<>();
14        for (int i = 0; i < m; ++i) {
15            for (int j = 0; j < n; ++j) {
16                if (rows[i] == cols[j]) {
17                    ans.add(rows[i]);
18                }
19            }
20        }
21        return ans;
22    }
23}