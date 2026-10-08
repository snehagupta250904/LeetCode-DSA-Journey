1class Solution {
2    public int heightChecker(int[] heights) {
3        int[] expected = heights.clone();
4        Arrays.sort(expected);
5        int ans = 0;
6        for (int i = 0; i < heights.length; ++i) {
7            if (heights[i] != expected[i]) {
8                ++ans;
9            }
10        }
11        return ans;
12    }
13}