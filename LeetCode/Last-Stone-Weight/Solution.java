1class Solution {
2    public int lastStoneWeight(int[] stones) {
3        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
4        for (int x : stones) {
5            q.offer(x);
6        }
7        while (q.size() > 1) {
8            int y = q.poll();
9            int x = q.poll();
10            if (x != y) {
11                q.offer(y - x);
12            }
13        }
14        return q.isEmpty() ? 0 : q.poll();
15    }
16}