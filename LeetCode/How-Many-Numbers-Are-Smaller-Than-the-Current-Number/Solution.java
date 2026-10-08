1class Solution {
2    public int[] smallerNumbersThanCurrent(int[] nums) {
3        int[] cnt = new int[102];
4        for (int x : nums) {
5            ++cnt[x + 1];
6        }
7        for (int i = 1; i < cnt.length; ++i) {
8            cnt[i] += cnt[i - 1];
9        }
10        int n = nums.length;
11        int[] ans = new int[n];
12        for (int i = 0; i < n; ++i) {
13            ans[i] = cnt[nums[i]];
14        }
15        return ans;
16    }
17}