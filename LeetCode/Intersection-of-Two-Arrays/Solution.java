1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        boolean[] s = new boolean[1001];
4        for (int x : nums1) {
5            s[x] = true;
6        }
7        List<Integer> ans = new ArrayList<>();
8        for (int x : nums2) {
9            if (s[x]) {
10                ans.add(x);
11                s[x] = false;
12            }
13        }
14        return ans.stream().mapToInt(Integer::intValue).toArray();
15    }
16}