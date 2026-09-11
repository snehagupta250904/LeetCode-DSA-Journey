1class Solution {
2    public List<String> twoEditWords(String[] queries, String[] dictionary) {
3        List<String> ans = new ArrayList<>();
4        int n = queries[0].length();
5        for (var s : queries) {
6            for (var t : dictionary) {
7                int cnt = 0;
8                for (int i = 0; i < n; ++i) {
9                    if (s.charAt(i) != t.charAt(i)) {
10                        ++cnt;
11                    }
12                }
13                if (cnt < 3) {
14                    ans.add(s);
15                    break;
16                }
17            }
18        }
19        return ans;
20    }
21}