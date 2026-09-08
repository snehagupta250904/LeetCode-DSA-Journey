1class Solution {
2    public int minimumEffort(int[][] tasks) {
3        Arrays.sort(tasks, (a, b) -> a[0] - b[0] - (a[1] - b[1]));
4        int ans = 0, cur = 0;
5        for (var task : tasks) {
6            int a = task[0], m = task[1];
7            if (cur < m) {
8                ans += m - cur;
9                cur = m;
10            }
11            cur -= a;
12        }
13        return ans;
14    }
15}