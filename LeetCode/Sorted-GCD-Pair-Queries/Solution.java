1class Solution {
2
3    public int[] gcdValues(int[] nums, long[] queries) {
4
5        int MAX = 50000;
6
7        // freq[x] = how many times x occurs
8        int[] freq = new int[MAX + 1];
9
10        for (int num : nums) {
11            freq[num]++;
12        }
13
14        // count[g] = number of pairs whose GCD is exactly g
15        long[] count = new long[MAX + 1];
16
17        /*
18         * First calculate number of pairs where
19         * both numbers are divisible by g.
20         */
21        for (int g = 1; g <= MAX; g++) {
22
23            long total = 0;
24
25            for (int multiple = g; multiple <= MAX; multiple += g) {
26                total += freq[multiple];
27            }
28
29            // Number of pairs among these elements
30            count[g] = total * (total - 1) / 2;
31        }
32
33        /*
34         * Remove pairs whose GCD is a multiple of g.
35         *
36         * After this:
37         * count[g] = number of pairs with GCD exactly g.
38         */
39        for (int g = MAX; g >= 1; g--) {
40
41            for (int multiple = g * 2; multiple <= MAX; multiple += g) {
42                count[g] -= count[multiple];
43            }
44        }
45
46        /*
47         * Prefix sum.
48         *
49         * prefix[g] = number of pairs whose GCD <= g
50         */
51        long[] prefix = new long[MAX + 1];
52
53        for (int g = 1; g <= MAX; g++) {
54            prefix[g] = prefix[g - 1] + count[g];
55        }
56
57        int[] answer = new int[queries.length];
58
59        for (int i = 0; i < queries.length; i++) {
60
61            long query = queries[i];
62
63            // Binary search for the smallest GCD
64            // whose prefix count > query.
65            int left = 1;
66            int right = MAX;
67
68            while (left < right) {
69
70                int mid = left + (right - left) / 2;
71
72                if (prefix[mid] > query) {
73                    right = mid;
74                } else {
75                    left = mid + 1;
76                }
77            }
78
79            answer[i] = left;
80        }
81
82        return answer;
83    }
84}