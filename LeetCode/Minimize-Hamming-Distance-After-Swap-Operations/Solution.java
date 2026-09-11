1class Solution {
2    private int[] p;
3
4    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
5        int n = source.length;
6        p = new int[n];
7        for (int i = 0; i < n; ++i) {
8            p[i] = i;
9        }
10        for (int[] e : allowedSwaps) {
11            p[find(e[0])] = find(e[1]);
12        }
13        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
14        for (int i = 0; i < n; ++i) {
15            int root = find(i);
16            mp.computeIfAbsent(root, k -> new HashMap<>())
17                .put(source[i], mp.get(root).getOrDefault(source[i], 0) + 1);
18        }
19        int res = 0;
20        for (int i = 0; i < n; ++i) {
21            int root = find(i);
22            if (mp.get(root).getOrDefault(target[i], 0) > 0) {
23                mp.get(root).put(target[i], mp.get(root).get(target[i]) - 1);
24            } else {
25                ++res;
26            }
27        }
28        return res;
29    }
30
31    private int find(int x) {
32        if (p[x] != x) {
33            p[x] = find(p[x]);
34        }
35        return p[x];
36    }
37}