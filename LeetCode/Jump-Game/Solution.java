1class Solution {
2    public boolean canJump(int[] nums) {
3        int mx = 0;
4        for (int i = 0; i < nums.length; ++i) {
5            if (mx < i) {
6                return false;
7            }
8            mx = Math.max(mx, i + nums[i]);
9        }
10        return true;
11    }
12}