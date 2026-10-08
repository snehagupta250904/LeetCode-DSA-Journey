1class Solution {
2    public int numTilePossibilities(String tiles) {
3        int[] cnt = new int[26];
4        for (char c : tiles.toCharArray()) {
5            ++cnt[c - 'A'];
6        }
7        return dfs(cnt);
8    }
9
10    private int dfs(int[] cnt) {
11        int res = 0;
12        for (int i = 0; i < cnt.length; ++i) {
13            if (cnt[i] > 0) {
14                ++res;
15                --cnt[i];
16                res += dfs(cnt);
17                ++cnt[i];
18            }
19        }
20        return res;
21    }
22}