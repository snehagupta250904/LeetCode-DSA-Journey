1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n = nums.length;
4        int[] ans = new int[n];
5
6        int total = 0;
7        for (int x : nums)
8            total += x;
9
10        int left = 0;
11
12        for (int i = 0; i < n; i++) {
13            total -= nums[i]; // right sum
14            ans[i] = Math.abs(left - total);
15            left += nums[i];
16        }
17
18        return ans;
19    }
20}