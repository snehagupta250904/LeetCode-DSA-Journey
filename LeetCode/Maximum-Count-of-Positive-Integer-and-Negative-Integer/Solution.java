1class Solution {
2    public int maximumCount(int[] nums) {
3        int a = nums.length - search(nums, 1);
4        int b = search(nums, 0);
5        return Math.max(a, b);
6    }
7
8    private int search(int[] nums, int x) {
9        int left = 0, right = nums.length;
10        while (left < right) {
11            int mid = (left + right) >> 1;
12            if (nums[mid] >= x) {
13                right = mid;
14            } else {
15                left = mid + 1;
16            }
17        }
18        return left;
19    }
20}