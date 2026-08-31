1class Solution {
2    public int maxArea(int[] height) {
3        int i = 0, j = height.length - 1;
4        int ans = 0;
5        while (i < j) {
6            int t = Math.min(height[i], height[j]) * (j - i);
7            ans = Math.max(ans, t);
8            if (height[i] < height[j]) {
9                ++i;
10            } else {
11                --j;
12            }
13        }
14        return ans;
15    }
16}