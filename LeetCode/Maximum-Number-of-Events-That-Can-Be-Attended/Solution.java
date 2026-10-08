1class Solution {
2    public int maxEvents(int[][] events) {
3        Map<Integer, List<Integer>> d = new HashMap<>();
4        int i = Integer.MAX_VALUE, j = 0;
5        for (var v : events) {
6            int s = v[0], e = v[1];
7            d.computeIfAbsent(s, k -> new ArrayList<>()).add(e);
8            i = Math.min(i, s);
9            j = Math.max(j, e);
10        }
11        PriorityQueue<Integer> q = new PriorityQueue<>();
12        int ans = 0;
13        for (int s = i; s <= j; ++s) {
14            while (!q.isEmpty() && q.peek() < s) {
15                q.poll();
16            }
17            for (int e : d.getOrDefault(s, Collections.emptyList())) {
18                q.offer(e);
19            }
20            if (!q.isEmpty()) {
21                q.poll();
22                ++ans;
23            }
24        }
25        return ans;
26    }
27}