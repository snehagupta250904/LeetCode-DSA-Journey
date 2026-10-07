1class Solution {
2    public boolean increasingTriplet(int[] nums) {
3        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
4        for (int num : nums) {
5            if (num > mid) {
6                return true;
7            }
8            if (num <= min) {
9                min = num;
10            } else {
11                mid = num;
12            }
13        }
14        return false;
15    }
16}