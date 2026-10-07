1class Solution {
2    private static final int MX = 100001;
3    private static final int MOD = 1_000_000_007;
4    private static final long[] POW10 = new long[MX];
5
6    static {
7        POW10[0] = 1;
8        for (int i = 1; i < MX; i++) {
9            POW10[i] = POW10[i - 1] * 10 % MOD;
10        }
11    }
12
13    public int[] sumAndMultiply(String s, int[][] queries) {
14        int n = s.length();
15        int[] sumD = new int[n + 1];
16        int[] cntN0 = new int[n + 1];
17        long[] p = new long[n + 1];
18
19        for (int i = 1; i <= n; i++) {
20            int d = s.charAt(i - 1) - '0';
21            sumD[i] = sumD[i - 1] + d;
22            cntN0[i] = cntN0[i - 1] + (d > 0 ? 1 : 0);
23            p[i] = d > 0 ? (p[i - 1] * 10 + d) % MOD : p[i - 1];
24        }
25
26        int[] ans = new int[queries.length];
27        for (int i = 0; i < queries.length; i++) {
28            int l = queries[i][0], r = queries[i][1];
29            int n0 = cntN0[r + 1] - cntN0[l];
30            int sd = sumD[r + 1] - sumD[l];
31            long x = (p[r + 1] - p[l] * POW10[n0] % MOD + MOD) % MOD;
32            ans[i] = (int) (x * sd % MOD);
33        }
34        return ans;
35    }
36}
37