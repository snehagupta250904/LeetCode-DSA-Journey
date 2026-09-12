1import java.util.*;
2
3class Solution {
4
5    static class Interval {
6        int l, r, w, idx;
7
8        Interval(int l, int r, int w, int idx) {
9            this.l = l;
10            this.r = r;
11            this.w = w;
12            this.idx = idx;
13        }
14    }
15
16    static class State {
17        long score;
18        int[] indices;
19
20        State(long score, int[] indices) {
21            this.score = score;
22            this.indices = indices;
23        }
24    }
25
26    public int[] maximumWeight(List<List<Integer>> intervals) {
27
28        int n = intervals.size();
29
30        Interval[] arr = new Interval[n];
31
32        for (int i = 0; i < n; i++) {
33            arr[i] = new Interval(
34                intervals.get(i).get(0),
35                intervals.get(i).get(1),
36                intervals.get(i).get(2),
37                i
38            );
39        }
40
41        // Sort by starting position
42        Arrays.sort(arr, (a, b) -> {
43            if (a.l != b.l) {
44                return Integer.compare(a.l, b.l);
45            }
46            return Integer.compare(a.r, b.r);
47        });
48
49        // Find next interval whose start > current end
50        int[] next = new int[n];
51
52        for (int i = 0; i < n; i++) {
53
54            int low = i + 1;
55            int high = n;
56
57            while (low < high) {
58
59                int mid = low + (high - low) / 2;
60
61                if (arr[mid].l > arr[i].r) {
62                    high = mid;
63                } else {
64                    low = mid + 1;
65                }
66            }
67
68            next[i] = low;
69        }
70
71        /*
72         * dp[k][i] =
73         * best answer when we can select at most k intervals
74         * from i onwards.
75         */
76        State[][] dp = new State[5][n + 1];
77
78        // Initialize EVERY state
79        for (int k = 0; k <= 4; k++) {
80            for (int i = 0; i <= n; i++) {
81                dp[k][i] = new State(0, new int[0]);
82            }
83        }
84
85        // DP
86        for (int k = 1; k <= 4; k++) {
87
88            for (int i = n - 1; i >= 0; i--) {
89
90                // Option 1: Skip current interval
91                State skip = dp[k][i + 1];
92
93                // Option 2: Take current interval
94                State nextState = dp[k - 1][next[i]];
95
96                long newScore = arr[i].w + nextState.score;
97
98                int[] newIndices =
99                    new int[nextState.indices.length + 1];
100
101                newIndices[0] = arr[i].idx;
102
103                System.arraycopy(
104                    nextState.indices,
105                    0,
106                    newIndices,
107                    1,
108                    nextState.indices.length
109                );
110
111                // Sort original indices
112                Arrays.sort(newIndices);
113
114                State take = new State(newScore, newIndices);
115
116                dp[k][i] = better(skip, take);
117            }
118        }
119
120        return dp[4][0].indices;
121    }
122
123    // Select better state
124    static State better(State a, State b) {
125
126        // Maximum score
127        if (a.score != b.score) {
128            return a.score > b.score ? a : b;
129        }
130
131        // Same score -> lexicographically smaller
132        if (lexicographicallySmaller(a.indices, b.indices)) {
133            return a;
134        }
135
136        return b;
137    }
138
139    static boolean lexicographicallySmaller(int[] a, int[] b) {
140
141        int len = Math.min(a.length, b.length);
142
143        for (int i = 0; i < len; i++) {
144
145            if (a[i] != b[i]) {
146                return a[i] < b[i];
147            }
148        }
149
150        return a.length < b.length;
151    }
152}