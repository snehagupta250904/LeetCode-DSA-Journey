1class Solution {
2    public List<Boolean> camelMatch(String[] queries, String pattern) {
3        List<Boolean> ans = new ArrayList<>();
4
5        for (String query : queries) {
6            ans.add(matches(query, pattern));
7        }
8
9        return ans;
10    }
11
12    private boolean matches(String query, String pattern) {
13        int j = 0;
14
15        for (int i = 0; i < query.length(); i++) {
16            char ch = query.charAt(i);
17
18            if (j < pattern.length() && ch == pattern.charAt(j)) {
19                j++;
20            } 
21            else if (Character.isUpperCase(ch)) {
22                return false;
23            }
24        }
25
26        return j == pattern.length();
27    }
28}