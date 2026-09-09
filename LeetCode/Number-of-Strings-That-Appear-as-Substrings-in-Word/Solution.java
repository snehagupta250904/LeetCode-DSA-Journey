1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int ans = 0;
4        for (String p : patterns) {
5            if (word.contains(p)) {
6                ++ans;
7            }
8        }
9        return ans;
10    }
11}