1class Solution {
2    public int numberOfSpecialChars(String word) {
3        boolean[] s = new boolean['z' + 1];
4        for (int i = 0; i < word.length(); ++i) {
5            s[word.charAt(i)] = true;
6        }
7        int ans = 0;
8        for (int i = 0; i < 26; ++i) {
9            if (s['a' + i] && s['A' + i]) {
10                ++ans;
11            }
12        }
13        return ans;
14    }
15}