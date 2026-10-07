1class Solution {
2    public String reverseVowels(String s) {
3        boolean[] vowels = new boolean[128];
4        for (char c : "aeiouAEIOU".toCharArray()) {
5            vowels[c] = true;
6        }
7        char[] cs = s.toCharArray();
8        int i = 0, j = cs.length - 1;
9        while (i < j) {
10            while (i < j && !vowels[cs[i]]) {
11                ++i;
12            }
13            while (i < j && !vowels[cs[j]]) {
14                --j;
15            }
16            if (i < j) {
17                char t = cs[i];
18                cs[i] = cs[j];
19                cs[j] = t;
20                ++i;
21                --j;
22            }
23        }
24        return String.valueOf(cs);
25    }
26}