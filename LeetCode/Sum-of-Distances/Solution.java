1class Solution {
2    public long[] distance(int[] nums) {
3        int n = nums.length;
4        long[] ans = new long[n];
5
6        Map<Integer, Long> sum = new HashMap<>();
7        Map<Integer, Integer> count = new HashMap<>();
8
9        // Left side contribution
10        for (int i = 0; i < n; i++) {
11            int x = nums[i];
12
13            long s = sum.getOrDefault(x, 0L);
14            int c = count.getOrDefault(x, 0);
15
16            ans[i] += (long) i * c - s;
17
18            sum.put(x, s + i);
19            count.put(x, c + 1);
20        }
21
22        sum.clear();
23        count.clear();
24
25        // Right side contribution
26        for (int i = n - 1; i >= 0; i--) {
27            int x = nums[i];
28
29            long s = sum.getOrDefault(x, 0L);
30            int c = count.getOrDefault(x, 0);
31
32            ans[i] += s - (long) i * c;
33
34            sum.put(x, s + i);
35            count.put(x, c + 1);
36        }
37
38        return ans;
39    }
40}