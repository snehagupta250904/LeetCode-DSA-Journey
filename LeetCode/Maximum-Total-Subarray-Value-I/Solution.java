1
2class Solution {
3    public long maxTotalValue(int[] nums, int k) {
4
5        int max = nums[0];
6        int min = nums[0];
7
8        for (int num : nums) {
9            max = Math.max(max, num);
10            min = Math.min(min, num);
11        }
12
13        return (long) (max - (long) min) * k;
14    }
15}
16