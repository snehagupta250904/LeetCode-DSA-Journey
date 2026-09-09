1class Solution {
2    public int numberOfSubstrings(String s) {
3        int[] last = {-1, -1, -1};
4        long count = 0;
5
6        for (int i = 0; i < s.length(); i++) {
7            last[s.charAt(i) - 'a'] = i;
8
9            int minLast = Math.min(last[0], Math.min(last[1], last[2]));
10
11            if (minLast != -1) {
12                count += minLast + 1;
13            }
14        }
15
16        return (int) count;
17    }
18}
19