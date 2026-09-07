1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        int n = nums.length;
4        Map<Integer, Integer> pos = new HashMap<>(n);
5        int ans = n + 1;
6        for (int i = 0; i < n; ++i) {
7            if (pos.containsKey(nums[i])) {
8                ans = Math.min(ans, i - pos.get(nums[i]));
9            }
10            pos.put(reverse(nums[i]), i);
11        }
12        return ans > n ? -1 : ans;
13    }
14
15    private int reverse(int x) {
16        int y = 0;
17        for (; x > 0; x /= 10) {
18            y = y * 10 + x % 10;
19        }
20        return y;
21    }
22}