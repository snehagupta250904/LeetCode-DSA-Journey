1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3        Map<Integer, Integer> counter = new HashMap<>();
4        for (int num : nums1) {
5            counter.put(num, counter.getOrDefault(num, 0) + 1);
6        }
7        List<Integer> t = new ArrayList<>();
8        for (int num : nums2) {
9            if (counter.getOrDefault(num, 0) > 0) {
10                t.add(num);
11                counter.put(num, counter.get(num) - 1);
12            }
13        }
14        int[] res = new int[t.size()];
15        for (int i = 0; i < res.length; ++i) {
16            res[i] = t.get(i);
17        }
18        return res;
19    }
20}