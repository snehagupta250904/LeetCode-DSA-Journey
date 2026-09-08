1class Solution {
2    private Integer[] f;
3    private int[] nums;
4    private int n;
5    private int target;
6
7    public int maximumJumps(int[] nums, int target) {
8        n = nums.length;
9        this.target = target;
10        this.nums = nums;
11        f = new Integer[n];
12        int ans = dfs(0);
13        return ans < 0 ? -1 : ans;
14    }
15
16    private int dfs(int i) {
17        if (i == n - 1) {
18            return 0;
19        }
20        if (f[i] != null) {
21            return f[i];
22        }
23        int ans = -(1 << 30);
24        for (int j = i + 1; j < n; ++j) {
25            if (Math.abs(nums[i] - nums[j]) <= target) {
26                ans = Math.max(ans, 1 + dfs(j));
27            }
28        }
29        return f[i] = ans;
30    }
31}