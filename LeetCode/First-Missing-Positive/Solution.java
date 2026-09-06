1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4        for (int i = 0; i < n; ++i) {
5            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
6                swap(nums, i, nums[i] - 1);
7            }
8        }
9        for (int i = 0; i < n; ++i) {
10            if (i + 1 != nums[i]) {
11                return i + 1;
12            }
13        }
14        return n + 1;
15    }
16
17    private void swap(int[] nums, int i, int j) {
18        int t = nums[i];
19        nums[i] = nums[j];
20        nums[j] = t;
21    }
22}