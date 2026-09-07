1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int min = Integer.MAX_VALUE;
4
5        for (int i = 0; i < nums.length; i++) {
6            if (nums[i] == target) {
7                min = Math.min(min, Math.abs(i - start));
8            }
9        }
10
11        return min;
12    }
13}