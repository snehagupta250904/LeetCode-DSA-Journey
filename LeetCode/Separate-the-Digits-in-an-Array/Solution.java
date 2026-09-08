1class Solution {
2    public int[] separateDigits(int[] nums) {
3        List<Integer> res = new ArrayList<>();
4        for (int x : nums) {
5            List<Integer> t = new ArrayList<>();
6            for (; x > 0; x /= 10) {
7                t.add(x % 10);
8            }
9            Collections.reverse(t);
10            res.addAll(t);
11        }
12        int[] ans = new int[res.size()];
13        for (int i = 0; i < ans.length; ++i) {
14            ans[i] = res.get(i);
15        }
16        return ans;
17    }
18}