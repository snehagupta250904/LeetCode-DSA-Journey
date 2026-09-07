1class Solution {
2    private static final int MOD = (int) 1e9 + 7;
3
4    public int distinctSubseqII(String s) {
5        int[] dp = new int[26];
6        int ans = 0;
7        for (int i = 0; i < s.length(); ++i) {
8            int j = s.charAt(i) - 'a';
9            int add = (ans - dp[j] + 1) % MOD;
10            ans = (ans + add) % MOD;
11            dp[j] = (dp[j] + add) % MOD;
12        }
13        return (ans + MOD) % MOD;
14    }
15}