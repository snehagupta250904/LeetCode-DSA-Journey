1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int m = nums1.length, n = nums2.length;
4        for (int i = 0, j = 0; i < m && j < n;) {
5            if (nums1[i] == nums2[j]) {
6                return nums1[i];
7            }
8            if (nums1[i] < nums2[j]) {
9                ++i;
10            } else {
11                ++j;
12            }
13        }
14        return -1;
15    }
16}