1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] right = new int[n];
5        right[n - 1] = nums[n - 1];
6
7        for (int i = n - 2; i >= 0; i--) {
8            right[i] = Math.min(right[i + 1], nums[i]);
9        }
10
11        int left = 0;
12        for (int i = 0; i < n; i++) {
13            left = Math.max(left, nums[i]);
14            if (left - right[i] <= k) {
15                return i;
16            }
17        }
18        return -1;
19    }
20}
21