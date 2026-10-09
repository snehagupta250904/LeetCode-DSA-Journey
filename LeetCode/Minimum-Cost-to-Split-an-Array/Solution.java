1class Solution {
2    private Integer[] f;
3    private int[] nums;
4    private int n, k;
5
6    public int minCost(int[] nums, int k) {
7        n = nums.length;
8        this.k = k;
9        this.nums = nums;
10        f = new Integer[n];
11        return dfs(0);
12    }
13
14    private int dfs(int i) {
15        if (i >= n) {
16            return 0;
17        }
18        if (f[i] != null) {
19            return f[i];
20        }
21        int[] cnt = new int[n];
22        int one = 0;
23        int ans = 1 << 30;
24        for (int j = i; j < n; ++j) {
25            int x = ++cnt[nums[j]];
26            if (x == 1) {
27                ++one;
28            } else if (x == 2) {
29                --one;
30            }
31            ans = Math.min(ans, k + j - i + 1 - one + dfs(j + 1));
32        }
33        return f[i] = ans;
34    }
35}