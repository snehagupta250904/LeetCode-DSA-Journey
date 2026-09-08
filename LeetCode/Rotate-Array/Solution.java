1class Solution {
2    private int[] nums;
3
4    public void rotate(int[] nums, int k) {
5        this.nums = nums;
6        int n = nums.length;
7        k %= n;
8        reverse(0, n - 1);
9        reverse(0, k - 1);
10        reverse(k, n - 1);
11    }
12
13    private void reverse(int i, int j) {
14        for (; i < j; ++i, --j) {
15            int t = nums[i];
16            nums[i] = nums[j];
17            nums[j] = t;
18        }
19    }
20}