1class Solution {
2    public int maxSum(List<Integer> nums, int k) {
3        final int mod = (int) 1e9 + 7;
4        int[] cnt = new int[31];
5        for (int x : nums) {
6            for (int i = 0; i < 31; ++i) {
7                if ((x >> i & 1) == 1) {
8                    ++cnt[i];
9                }
10            }
11        }
12        long ans = 0;
13        while (k-- > 0) {
14            int x = 0;
15            for (int i = 0; i < 31; ++i) {
16                if (cnt[i] > 0) {
17                    x |= 1 << i;
18                    --cnt[i];
19                }
20            }
21            ans = (ans + 1L * x * x) % mod;
22        }
23        return (int) ans;
24    }
25}