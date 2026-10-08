1class Solution {
2    public String sortString(String s) {
3        int[] cnt = new int[26];
4        int n = s.length();
5        for (int i = 0; i < n; ++i) {
6            cnt[s.charAt(i) - 'a']++;
7        }
8        StringBuilder sb = new StringBuilder();
9        while (sb.length() < n) {
10            for (int i = 0; i < 26; ++i) {
11                if (cnt[i] > 0) {
12                    sb.append((char) ('a' + i));
13                    --cnt[i];
14                }
15            }
16            for (int i = 25; i >= 0; --i) {
17                if (cnt[i] > 0) {
18                    sb.append((char) ('a' + i));
19                    --cnt[i];
20                }
21            }
22        }
23        return sb.toString();
24    }
25}