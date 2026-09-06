1public class House_Robber {
2    class Solution {
3        public int rob(int[] nums) {
4            if (nums == null || nums.length == 0) {
5                return 0;
6            }
7            int[] dp = new int[nums.length + 1];
8
9            dp[0] = 0;
10            dp[1] = nums[0];
11
12            for (int i = 2; i <= nums.length; i++) {
13                // 2 cases: rob current house, not rob current
14                dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
15            }
16            return dp[nums.length];
17        }
18    }
19}
20class Solution {
21    public int rob(int[] nums) {
22        int a = 0, b = nums[0];
23        for (int i = 1; i < nums.length; ++i) {
24            int c = Math.max(nums[i] + a, b);
25            a = b;
26            b = c;
27        }
28        return b;
29    }
30}