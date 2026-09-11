1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0, right = nums.length - 1;
4        while (left < right) {
5            int mid = (left + right) >> 1;
6            if (nums[mid] > nums[right]) {
7                left = mid + 1;
8            } else if (nums[mid] < nums[right]) {
9                right = mid;
10            } else {
11                --right;
12            }
13        }
14        return nums[left];
15    }
16}