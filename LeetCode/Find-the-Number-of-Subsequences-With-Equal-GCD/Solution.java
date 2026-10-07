1class Solution {
2    static final int MOD = 1_000_000_007;
3
4    public int subsequencePairCount(int[] nums) {
5        int n = nums.length;
6        int max = 200;
7
8        // dp[g1][g2] = number of ways
9        // to assign processed elements to seq1, seq2, or neither
10        long[][] dp = new long[max + 1][max + 1];
11
12        dp[0][0] = 1;
13
14        for (int num : nums) {
15            long[][] next = new long[max + 1][max + 1];
16
17            for (int g1 = 0; g1 <= max; g1++) {
18                for (int g2 = 0; g2 <= max; g2++) {
19
20                    if (dp[g1][g2] == 0) {
21                        continue;
22                    }
23
24                    long ways = dp[g1][g2];
25
26                    // 1. Don't use this element
27                    next[g1][g2] =
28                        (next[g1][g2] + ways) % MOD;
29
30                    // 2. Put this element in seq1
31                    int newG1 = gcd(g1, num);
32
33                    next[newG1][g2] =
34                        (next[newG1][g2] + ways) % MOD;
35
36                    // 3. Put this element in seq2
37                    int newG2 = gcd(g2, num);
38
39                    next[g1][newG2] =
40                        (next[g1][newG2] + ways) % MOD;
41                }
42            }
43
44            dp = next;
45        }
46
47        // Both subsequences must be non-empty,
48        // so gcd cannot be 0.
49        long ans = 0;
50
51        for (int g = 1; g <= max; g++) {
52            ans = (ans + dp[g][g]) % MOD;
53        }
54
55        return (int) ans;
56    }
57
58    private int gcd(int a, int b) {
59        if (a == 0) return b;
60
61        while (b != 0) {
62            int temp = a % b;
63            a = b;
64            b = temp;
65        }
66
67        return a;
68    }
69}