1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4
5        // Prefix sums range from -n to n.
6        // Shift by n + 1 so indices are positive.
7        int offset = n + 1;
8        FenwickTree bit = new FenwickTree(2 * n + 3);
9
10        long ans = 0;
11        int prefix = 0;
12
13        // Add prefix sum 0.
14        bit.add(offset, 1);
15
16        for (int num : nums) {
17            if (num == target) {
18                prefix++;
19            } else {
20                prefix--;
21            }
22
23            /*
24             * We need previous prefix < current prefix.
25             *
26             * prefix is shifted by offset.
27             * Query(offset + prefix - 1) gives the count
28             * of previous prefix sums strictly smaller than
29             * the current prefix.
30             */
31            int index = offset + prefix;
32
33            ans += bit.query(index - 1);
34
35            // Add current prefix sum.
36            bit.add(index, 1);
37        }
38
39        return ans;
40    }
41
42    static class FenwickTree {
43        private final int[] tree;
44
45        FenwickTree(int size) {
46            tree = new int[size + 1];
47        }
48
49        void add(int index, int value) {
50            while (index < tree.length) {
51                tree[index] += value;
52                index += index & -index;
53            }
54        }
55
56        int query(int index) {
57            int sum = 0;
58
59            while (index > 0) {
60                sum += tree[index];
61                index -= index & -index;
62            }
63
64            return sum;
65        }
66    }
67}
68