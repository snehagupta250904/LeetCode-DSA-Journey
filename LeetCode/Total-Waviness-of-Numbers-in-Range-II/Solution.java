1class Solution {
2    private char[] cs;
3    private long[][][][] cnt;
4    private long[][][][] wav;
5
6    public long totalWaviness(long num1, long num2) {
7        return calc(num2) - calc(num1 - 1);
8    }
9
10    private long calc(long x) {
11        if (x < 0) {
12            return 0;
13        }
14        cs = Long.toString(x).toCharArray();
15        int n = cs.length;
16        cnt = new long[n][11][11][2];
17        wav = new long[n][11][11][2];
18        for (int i = 0; i < n; ++i) {
19            for (int a = 0; a < 11; ++a) {
20                for (int b = 0; b < 11; ++b) {
21                    Arrays.fill(cnt[i][a][b], -1);
22                    Arrays.fill(wav[i][a][b], -1);
23                }
24            }
25        }
26        return dfs(0, 10, 10, 0, true)[1];
27    }
28
29    private long[] dfs(int pos, int prev2, int prev1, int started, boolean limit) {
30        if (pos == cs.length) {
31            return new long[] {started, 0};
32        }
33        if (!limit && cnt[pos][prev2][prev1][started] != -1) {
34            return new long[] {cnt[pos][prev2][prev1][started], wav[pos][prev2][prev1][started]};
35        }
36        int up = limit ? cs[pos] - '0' : 9;
37        long c = 0, w = 0;
38        for (int d = 0; d <= up; ++d) {
39            boolean nlimit = limit && d == up;
40            int ns, np2, np1, add = 0;
41            if (started == 0) {
42                if (d == 0) {
43                    ns = 0;
44                    np2 = 10;
45                    np1 = 10;
46                } else {
47                    ns = 1;
48                    np2 = 10;
49                    np1 = d;
50                }
51            } else {
52                ns = 1;
53                np2 = prev1;
54                np1 = d;
55                if (prev2 != 10 && ((prev1 > prev2 && prev1 > d) || (prev1 < prev2 && prev1 < d))) {
56                    add = 1;
57                }
58            }
59            long[] t = dfs(pos + 1, np2, np1, ns, nlimit);
60            c += t[0];
61            w += t[1] + t[0] * add;
62        }
63        if (!limit) {
64            cnt[pos][prev2][prev1][started] = c;
65            wav[pos][prev2][prev1][started] = w;
66        }
67        return new long[] {c, w};
68    }
69}