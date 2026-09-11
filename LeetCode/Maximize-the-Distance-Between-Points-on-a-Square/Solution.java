1class Solution {
2    public int maxDistance(int side, int[][] points, int k) {
3
4        int n = points.length;
5        long[] nums = new long[n];
6
7        // Convert every boundary point to a position
8        // on the perimeter of the square.
9        for (int i = 0; i < n; i++) {
10            int x = points[i][0];
11            int y = points[i][1];
12
13            if (x == 0) {
14                // Left side
15                nums[i] = y;
16            } 
17            else if (y == side) {
18                // Top side
19                nums[i] = (long) side + x;
20            } 
21            else if (x == side) {
22                // Right side
23                nums[i] = (long) 3 * side - y;
24            } 
25            else {
26                // Bottom side
27                nums[i] = (long) 4 * side - x;
28            }
29        }
30
31        Arrays.sort(nums);
32
33        long perimeter = 4L * side;
34
35        int left = 1;
36        int right = side;
37
38        while (left < right) {
39
40            int mid = left + (right - left + 1) / 2;
41
42            if (canChoose(nums, perimeter, k, mid)) {
43                left = mid;
44            } else {
45                right = mid - 1;
46            }
47        }
48
49        return left;
50    }
51
52    private boolean canChoose(long[] nums, long perimeter, int k, int dist) {
53
54        int n = nums.length;
55
56        /*
57         * Try every point as the first selected point.
58         */
59        for (int start = 0; start < n; start++) {
60
61            long first = nums[start];
62
63            // Last selected point must be at most this far
64            // so that it is also at least 'dist' away
65            // from the first point after wrapping around.
66            long limit = first + perimeter - dist;
67
68            long current = first;
69
70            boolean possible = true;
71
72            /*
73             * Greedily select the next point.
74             */
75            for (int count = 1; count < k; count++) {
76
77                long required = current + dist;
78
79                int next = lowerBound(nums, required);
80
81                if (next == n || nums[next] > limit) {
82                    possible = false;
83                    break;
84                }
85
86                current = nums[next];
87            }
88
89            if (possible) {
90                return true;
91            }
92        }
93
94        return false;
95    }
96
97    // First index i such that nums[i] >= target
98    private int lowerBound(long[] nums, long target) {
99
100        int left = 0;
101        int right = nums.length;
102
103        while (left < right) {
104
105            int mid = left + (right - left) / 2;
106
107            if (nums[mid] >= target) {
108                right = mid;
109            } else {
110                left = mid + 1;
111            }
112        }
113
114        return left;
115    }
116}