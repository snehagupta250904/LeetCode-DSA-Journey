1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        return Math.abs(count(moves, 'L') - count(moves, 'R')) + count(moves, '_');
4    }
5
6    private int count(String s, char c) {
7        int cnt = 0;
8        for (int i = 0; i < s.length(); ++i) {
9            if (s.charAt(i) == c) {
10                ++cnt;
11            }
12        }
13        return cnt;
14    }
15}