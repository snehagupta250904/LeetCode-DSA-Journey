1class Solution {
2    public int majorityElement(int[] nums) {
3        int cnt = 0, m = 0;
4        for (int x : nums) {
5            if (cnt == 0) {
6                m = x;
7                cnt = 1;
8            } else {
9                cnt += m == x ? 1 : -1;
10            }
11        }
12        return m;
13    }
14}