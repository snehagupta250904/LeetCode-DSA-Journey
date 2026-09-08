1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int n = nums.length;
4
5        long sum = 0;
6        long f = 0;
7
8        // Calculate sum of all elements and F(0)
9        for (int i = 0; i < n; i++) {
10            sum += nums[i];
11            f += (long) i * nums[i];
12        }
13
14        long max = f;
15
16        // F(k) = F(k-1) + sum - n * nums[n-k]
17        for (int k = 1; k < n; k++) {
18            f = f + sum - (long) n * nums[n - k];
19            max = Math.max(max, f);
20        }
21
22        return (int) max;
23    }
24}
25