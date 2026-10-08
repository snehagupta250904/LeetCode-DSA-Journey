1class Solution {
2    public String rankTeams(String[] votes) {
3        int n = votes[0].length();
4        int[][] cnt = new int[26][n];
5        for (var vote : votes) {
6            for (int i = 0; i < n; ++i) {
7                cnt[vote.charAt(i) - 'A'][i]++;
8            }
9        }
10        Character[] cs = new Character[n];
11        for (int i = 0; i < n; ++i) {
12            cs[i] = votes[0].charAt(i);
13        }
14        Arrays.sort(cs, (a, b) -> {
15            int i = a - 'A', j = b - 'A';
16            for (int k = 0; k < n; ++k) {
17                int d = cnt[i][k] - cnt[j][k];
18                if (d != 0) {
19                    return d > 0 ? -1 : 1;
20                }
21            }
22            return a - b;
23        });
24        StringBuilder ans = new StringBuilder();
25        for (char c : cs) {
26            ans.append(c);
27        }
28        return ans.toString();
29    }
30}