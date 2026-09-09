1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
4        int[] pre = intervals[0];
5        int cnt = 1;
6        for (int i = 1; i < intervals.length; ++i) {
7            if (pre[1] < intervals[i][1]) {
8                ++cnt;
9                pre = intervals[i];
10            }
11        }
12        return cnt;
13    }
14}