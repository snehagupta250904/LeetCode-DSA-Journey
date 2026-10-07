1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        List<Integer> ans = new ArrayList<>();
4        for (int i = 1; i < 9; ++i) {
5            int x = i;
6            for (int j = i + 1; j < 10; ++j) {
7                x = x * 10 + j;
8                if (x >= low && x <= high) {
9                    ans.add(x);
10                }
11            }
12        }
13        Collections.sort(ans);
14        return ans;
15    }
16}