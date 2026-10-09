1class Solution {
2    public int differenceOfSum(int[] nums) {
3        int a = 0, b = 0;
4        for (int x : nums) {
5            a += x;
6            for (; x > 0; x /= 10) {
7                b += x % 10;
8            }
9        }
10        return Math.abs(a - b);
11    }
12}