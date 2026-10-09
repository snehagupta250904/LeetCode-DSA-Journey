1class Solution {
2    public long countGood(int[] nums, int k) {
3        Map<Integer, Integer> cnt = new HashMap<>();
4        long ans = 0, cur = 0;
5        int i = 0;
6        for (int x : nums) {
7            cur += cnt.getOrDefault(x, 0);
8            cnt.merge(x, 1, Integer::sum);
9            while (cur - cnt.get(nums[i]) + 1 >= k) {
10                cur -= cnt.merge(nums[i++], -1, Integer::sum);
11            }
12            if (cur >= k) {
13                ans += i + 1;
14            }
15        }
16        return ans;
17    }
18}