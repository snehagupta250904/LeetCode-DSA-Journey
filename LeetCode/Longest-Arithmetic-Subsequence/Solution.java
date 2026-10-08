1class Solution {
2    public int longestArithSeqLength(int[] nums) {
3        int n = nums.length;
4        int ans = 0;
5        int[][] f = new int[n][1001];
6        for (int i = 1; i < n; ++i) {
7            for (int k = 0; k < i; ++k) {
8                int j = nums[i] - nums[k] + 500;
9                f[i][j] = Math.max(f[i][j], f[k][j] + 1);
10                ans = Math.max(ans, f[i][j]);
11            }
12        }
13        return ans + 1;
14    }
15}