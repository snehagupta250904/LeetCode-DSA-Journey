1class Solution {
2    public String getPermutation(int n, int k) {
3        StringBuilder ans = new StringBuilder();
4        boolean[] vis = new boolean[n + 1];
5        for (int i = 0; i < n; ++i) {
6            int fact = 1;
7            for (int j = 1; j < n - i; ++j) {
8                fact *= j;
9            }
10            for (int j = 1; j <= n; ++j) {
11                if (!vis[j]) {
12                    if (k > fact) {
13                        k -= fact;
14                    } else {
15                        ans.append(j);
16                        vis[j] = true;
17                        break;
18                    }
19                }
20            }
21        }
22        return ans.toString();
23    }
24}