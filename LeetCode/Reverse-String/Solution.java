1class Solution {
2    public void reverseString(char[] s) {
3        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
4            char t = s[i];
5            s[i] = s[j];
6            s[j] = t;
7        }
8    }
9}