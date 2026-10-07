1import java.util.*;
2
3class Solution {
4    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
5        
6        // Store {value, original index}
7        Integer[] order = new Integer[n];
8        for (int i = 0; i < n; i++) {
9            order[i] = i;
10        }
11
12        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));
13
14        // pos[i] = position of original node i in sorted order
15        int[] pos = new int[n];
16
17        int[] sorted = new int[n];
18
19        for (int i = 0; i < n; i++) {
20            sorted[i] = nums[order[i]];
21            pos[order[i]] = i;
22        }
23
24        /*
25         * next[i] = farthest position that can be reached
26         * in ONE edge from sorted position i.
27         *
28         * Since sorted[] is sorted, use two pointers.
29         */
30        int[] next = new int[n];
31        int r = 0;
32
33        for (int l = 0; l < n; l++) {
34            if (r < l) {
35                r = l;
36            }
37
38            while (r + 1 < n && sorted[r + 1] - sorted[l] <= maxDiff) {
39                r++;
40            }
41
42            next[l] = r;
43        }
44
45        /*
46         * Binary lifting.
47         *
48         * up[k][i] = farthest position reachable after
49         * 2^k jumps.
50         */
51        int LOG = 18; // 2^17 > 100000
52
53        int[][] up = new int[LOG][n];
54
55        for (int i = 0; i < n; i++) {
56            up[0][i] = next[i];
57        }
58
59        for (int k = 1; k < LOG; k++) {
60            for (int i = 0; i < n; i++) {
61                up[k][i] = up[k - 1][up[k - 1][i]];
62            }
63        }
64
65        int[] answer = new int[queries.length];
66
67        for (int q = 0; q < queries.length; q++) {
68
69            int u = pos[queries[q][0]];
70            int v = pos[queries[q][1]];
71
72            // Same node
73            if (u == v) {
74                answer[q] = 0;
75                continue;
76            }
77
78            // Always move from left to right
79            if (u > v) {
80                int temp = u;
81                u = v;
82                v = temp;
83            }
84
85            // If v cannot be reached from u
86            if (next[u] == u) {
87                answer[q] = -1;
88                continue;
89            }
90
91            int current = u;
92            int distance = 0;
93
94            /*
95             * Find minimum number of jumps needed
96             * to reach or pass v.
97             */
98            for (int k = LOG - 1; k >= 0; k--) {
99
100                int far = up[k][current];
101
102                if (far < v) {
103                    current = far;
104                    distance += (1 << k);
105                }
106            }
107
108            // One final jump reaches v
109            if (next[current] >= v) {
110                answer[q] = distance + 1;
111            } else {
112                answer[q] = -1;
113            }
114        }
115
116        return answer;
117    }
118}