1class Solution {
2    public List<String> findRepeatedDnaSequences(String s) {
3        Map<String, Integer> cnt = new HashMap<>();
4        List<String> ans = new ArrayList<>();
5        for (int i = 0; i < s.length() - 10 + 1; ++i) {
6            String t = s.substring(i, i + 10);
7            if (cnt.merge(t, 1, Integer::sum) == 2) {
8                ans.add(t);
9            }
10        }
11        return ans;
12    }
13}