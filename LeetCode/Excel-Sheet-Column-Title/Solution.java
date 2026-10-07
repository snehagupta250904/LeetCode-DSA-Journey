1class Solution {
2    public String convertToTitle(int columnNumber) {
3
4        StringBuilder sb = new StringBuilder();
5
6        while (columnNumber > 0) {
7
8            columnNumber--;
9
10            char ch = (char) ('A' + columnNumber % 26);
11            sb.append(ch);
12
13            columnNumber /= 26;
14        }
15
16        return sb.reverse().toString();
17    }
18}