1class Solution {
2    public int earliestFinishTime(
3        int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
4        int x = calc(landStartTime, landDuration, waterStartTime, waterDuration);
5        int y = calc(waterStartTime, waterDuration, landStartTime, landDuration);
6        return Math.min(x, y);
7    }
8
9    private int calc(int[] a1, int[] t1, int[] a2, int[] t2) {
10        int minEnd = Integer.MAX_VALUE;
11        for (int i = 0; i < a1.length; ++i) {
12            minEnd = Math.min(minEnd, a1[i] + t1[i]);
13        }
14        int ans = Integer.MAX_VALUE;
15        for (int i = 0; i < a2.length; ++i) {
16            ans = Math.min(ans, Math.max(minEnd, a2[i]) + t2[i]);
17        }
18        return ans;
19    }
20}