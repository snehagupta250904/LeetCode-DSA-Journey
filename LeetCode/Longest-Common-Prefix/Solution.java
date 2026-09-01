1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        int n = strs.length;
4        for (int i = 0; i < strs[0].length(); ++i) {
5            for (int j = 1; j < n; ++j) {
6                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
7                    return strs[0].substring(0, i);
8                }
9            }
10        }
11        return strs[0];
12    }
13}