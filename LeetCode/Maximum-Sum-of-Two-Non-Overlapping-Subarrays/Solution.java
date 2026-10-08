1class Solution {
2    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
3        int n = nums.length;
4        int[] s = new int[n + 1];
5        for (int i = 0; i < n; ++i) {
6            s[i + 1] = s[i] + nums[i];
7        }
8        int ans = 0;
9        for (int i = firstLen, t = 0; i + secondLen - 1 < n; ++i) {
10            t = Math.max(t, s[i] - s[i - firstLen]);
11            ans = Math.max(ans, t + s[i + secondLen] - s[i]);
12        }
13        for (int i = secondLen, t = 0; i + firstLen - 1 < n; ++i) {
14            t = Math.max(t, s[i] - s[i - secondLen]);
15            ans = Math.max(ans, t + s[i + firstLen] - s[i]);
16        }
17        return ans;
18    }
19}