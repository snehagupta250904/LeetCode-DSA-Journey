1class Solution {
2    public int titleToNumber(String columnTitle) {
3        int res = 0;
4        for (char c : columnTitle.toCharArray()) {
5            res = res * 26 + (c - 'A' + 1);
6        }
7        return res;
8    }
9}