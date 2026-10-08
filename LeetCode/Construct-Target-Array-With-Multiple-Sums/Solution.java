1class Solution {
2    public boolean isPossible(int[] target) {
3        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
4        long s = 0;
5        for (int x : target) {
6            s += x;
7            pq.offer((long) x);
8        }
9        while (pq.peek() > 1) {
10            long mx = pq.poll();
11            long t = s - mx;
12            if (t == 0 || mx - t < 1) {
13                return false;
14            }
15            long x = mx % t;
16            if (x == 0) {
17                x = t;
18            }
19            pq.offer(x);
20            s = s - mx + x;
21        }
22        return true;
23    }
24}