1class Solution {
2    public int numSubmatrixSumTarget(int[][] matrix, int target) {
3        int m = matrix.length, n = matrix[0].length;
4        int ans = 0;
5        for (int i = 0; i < m; ++i) {
6            int[] col = new int[n];
7            for (int j = i; j < m; ++j) {
8                for (int k = 0; k < n; ++k) {
9                    col[k] += matrix[j][k];
10                }
11                ans += f(col, target);
12            }
13        }
14        return ans;
15    }
16
17    private int f(int[] nums, int target) {
18        Map<Integer, Integer> d = new HashMap<>();
19        d.put(0, 1);
20        int s = 0, cnt = 0;
21        for (int x : nums) {
22            s += x;
23            cnt += d.getOrDefault(s - target, 0);
24            d.merge(s, 1, Integer::sum);
25        }
26        return cnt;
27    }
28}