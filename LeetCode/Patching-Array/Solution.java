1class Solution {
2    public int minPatches(int[] nums, int n) {
3        long x = 1;
4        int ans = 0;
5        for (int i = 0; x <= n;) {
6            if (i < nums.length && nums[i] <= x) {
7                x += nums[i++];
8            } else {
9                ++ans;
10                x <<= 1;
11            }
12        }
13        return ans;
14    }
15}