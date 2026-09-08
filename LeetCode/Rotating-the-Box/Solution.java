1class Solution {
2    public char[][] rotateTheBox(char[][] box) {
3        int m = box.length, n = box[0].length;
4        char[][] ans = new char[n][m];
5        for (int i = 0; i < m; ++i) {
6            for (int j = 0; j < n; ++j) {
7                ans[j][m - i - 1] = box[i][j];
8            }
9        }
10        for (int j = 0; j < m; ++j) {
11            Deque<Integer> q = new ArrayDeque<>();
12            for (int i = n - 1; i >= 0; --i) {
13                if (ans[i][j] == '*') {
14                    q.clear();
15                } else if (ans[i][j] == '.') {
16                    q.offer(i);
17                } else if (!q.isEmpty()) {
18                    ans[q.pollFirst()][j] = '#';
19                    ans[i][j] = '.';
20                    q.offer(i);
21                }
22            }
23        }
24        return ans;
25    }
26}