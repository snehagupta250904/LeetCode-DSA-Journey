1class Solution {
2    public long maxKelements(int[] nums, int k) {
3        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
4        for (int v : nums) {
5            pq.offer(v);
6        }
7        long ans = 0;
8        while (k-- > 0) {
9            int v = pq.poll();
10            ans += v;
11            pq.offer((v + 2) / 3);
12        }
13        return ans;
14    }
15}