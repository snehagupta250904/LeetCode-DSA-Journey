1class Solution {
2    public boolean isNumber(String s) {
3        int n = s.length();
4        int i = 0;
5        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
6            ++i;
7        }
8        if (i == n) {
9            return false;
10        }
11        if (s.charAt(i) == '.'
12            && (i + 1 == n || s.charAt(i + 1) == 'e' || s.charAt(i + 1) == 'E')) {
13            return false;
14        }
15        int dot = 0, e = 0;
16        for (int j = i; j < n; ++j) {
17            if (s.charAt(j) == '.') {
18                if (e > 0 || dot > 0) {
19                    return false;
20                }
21                ++dot;
22            } else if (s.charAt(j) == 'e' || s.charAt(j) == 'E') {
23                if (e > 0 || j == i || j == n - 1) {
24                    return false;
25                }
26                ++e;
27                if (s.charAt(j + 1) == '+' || s.charAt(j + 1) == '-') {
28                    if (++j == n - 1) {
29                        return false;
30                    }
31                }
32            } else if (s.charAt(j) < '0' || s.charAt(j) > '9') {
33                return false;
34            }
35        }
36        return true;
37    }
38}