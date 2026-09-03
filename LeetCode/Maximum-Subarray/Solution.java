1class Solution {
2    public int maxSubArray(int[] nums) {
3       int ans = nums[0];
4        for (int i = 1, f = nums[0]; i < nums.length; ++i) {
5            f = Math.max(f, 0) + nums[i];
6            ans = Math.max(ans, f);
7        }
8        return ans; 
9    }
10}