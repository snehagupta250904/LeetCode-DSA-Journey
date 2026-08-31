1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        Arrays.sort(nums);
4        int ans = 1 << 30;
5        int n = nums.length;
6        for (int i = 0; i < n; ++i) {
7            int j = i + 1, k = n - 1;
8            while (j < k) {
9                int t = nums[i] + nums[j] + nums[k];
10                if (t == target) {
11                    return t;
12                }
13                if (Math.abs(t - target) < Math.abs(ans - target)) {
14                    ans = t;
15                }
16                if (t > target) {
17                    --k;
18                } else {
19                    ++j;
20                }
21            }
22        }
23        return ans;
24    }
25}