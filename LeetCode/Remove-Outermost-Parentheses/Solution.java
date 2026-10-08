1class Solution {
2    public String removeOuterParentheses(String s) {
3        StringBuilder ans = new StringBuilder();
4        int count = 0;
5
6        for (char ch : s.toCharArray()) {
7
8            if (ch == '(') {
9                // Add '(' only if it is NOT the outermost
10                if (count > 0) {
11                    ans.append(ch);
12                }
13                count++;
14            } 
15            else {
16                count--;
17
18                // Add ')' only if it is NOT the outermost
19                if (count > 0) {
20                    ans.append(ch);
21                }
22            }
23        }
24
25        return ans.toString();
26    }
27}