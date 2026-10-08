1class Solution {
2    private int[] p;
3
4    public String smallestEquivalentString(String s1, String s2, String baseStr) {
5        p = new int[26];
6        for (int i = 0; i < 26; ++i) {
7            p[i] = i;
8        }
9        for (int i = 0; i < s1.length(); ++i) {
10            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
11            int pa = find(a), pb = find(b);
12            if (pa < pb) {
13                p[pb] = pa;
14            } else {
15                p[pa] = pb;
16            }
17        }
18        StringBuilder sb = new StringBuilder();
19        for (char a : baseStr.toCharArray()) {
20            char b = (char) (find(a - 'a') + 'a');
21            sb.append(b);
22        }
23        return sb.toString();
24    }
25
26    private int find(int x) {
27        if (p[x] != x) {
28            p[x] = find(p[x]);
29        }
30        return p[x];
31    }
32}