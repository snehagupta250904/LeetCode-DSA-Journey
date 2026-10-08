1class Solution {
2    public int maxEqualRowsAfterFlips(int[][] matrix) {
3        Map<String, Integer> cnt = new HashMap<>();
4        int ans = 0, n = matrix[0].length;
5        for (var row : matrix) {
6            char[] cs = new char[n];
7            for (int i = 0; i < n; ++i) {
8                cs[i] = (char) (row[0] ^ row[i]);
9            }
10            ans = Math.max(ans, cnt.merge(String.valueOf(cs), 1, Integer::sum));
11        }
12        return ans;
13    }
14}