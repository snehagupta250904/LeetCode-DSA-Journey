1class Solution {
2    private long[] p;
3    private long[] h;
4
5    public String longestDupSubstring(String s) {
6        int base = 131;
7        int n = s.length();
8        p = new long[n + 10];
9        h = new long[n + 10];
10        p[0] = 1;
11        for (int i = 0; i < n; ++i) {
12            p[i + 1] = p[i] * base;
13            h[i + 1] = h[i] * base + s.charAt(i);
14        }
15        String ans = "";
16        int left = 0, right = n;
17        while (left < right) {
18            int mid = (left + right + 1) >> 1;
19            String t = check(s, mid);
20            if (t.length() > 0) {
21                left = mid;
22                ans = t;
23            } else {
24                right = mid - 1;
25            }
26        }
27        return ans;
28    }
29
30    private String check(String s, int len) {
31        int n = s.length();
32        Set<Long> vis = new HashSet<>();
33        for (int i = 1; i + len - 1 <= n; ++i) {
34            int j = i + len - 1;
35            long t = h[j] - h[i - 1] * p[j - i + 1];
36            if (vis.contains(t)) {
37                return s.substring(i - 1, j);
38            }
39            vis.add(t);
40        }
41        return "";
42    }
43}