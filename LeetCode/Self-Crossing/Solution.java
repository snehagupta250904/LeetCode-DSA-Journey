1class Solution {
2    public boolean isSelfCrossing(int[] distance) {
3        int[] d = distance;
4        for (int i = 3; i < d.length; ++i) {
5            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) {
6                return true;
7            }
8            if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2]) {
9                return true;
10            }
11            if (i >= 5 && d[i - 2] >= d[i - 4] && d[i - 1] <= d[i - 3]
12                && d[i] >= d[i - 2] - d[i - 4] && d[i - 1] + d[i - 5] >= d[i - 3]) {
13                return true;
14            }
15        }
16        return false;
17    }
18}