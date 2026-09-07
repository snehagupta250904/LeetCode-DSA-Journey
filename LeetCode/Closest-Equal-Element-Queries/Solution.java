1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        int n = nums.length;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5
6        // Store indices for each value
7        for (int i = 0; i < n; i++) {
8            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
9        }
10
11        List<Integer> ans = new ArrayList<>();
12
13        for (int q : queries) {
14            List<Integer> list = map.get(nums[q]);
15
16            if (list.size() == 1) {
17                ans.add(-1);
18                continue;
19            }
20
21            int pos = Collections.binarySearch(list, q);
22            int m = list.size();
23
24            int prev = list.get((pos - 1 + m) % m);
25            int next = list.get((pos + 1) % m);
26
27            int d1 = Math.abs(q - prev);
28            int d2 = Math.abs(q - next);
29
30            // Circular distance
31            d1 = Math.min(d1, n - d1);
32            d2 = Math.min(d2, n - d2);
33
34            ans.add(Math.min(d1, d2));
35        }
36
37        return ans;
38    }
39}