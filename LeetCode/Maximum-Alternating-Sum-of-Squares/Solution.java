1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        int n = nums.length;
4        for (int i = 0; i < n; ++i) {
5            nums[i] *= nums[i];
6        }
7        Arrays.sort(nums);
8        long ans = 0;
9        int m = n / 2;
10        for (int i = 0; i < m; ++i) {
11            ans -= nums[i];
12        }
13        for (int i = m; i < n; ++i) {
14            ans += nums[i];
15        }
16        return ans;
17    }
18}