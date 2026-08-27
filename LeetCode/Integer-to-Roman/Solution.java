1class Solution {
2    public String intToRoman(int num) {
3        List<String> cs
4            = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
5        List<Integer> vs = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
6        StringBuilder ans = new StringBuilder();
7        for (int i = 0, n = cs.size(); i < n; ++i) {
8            while (num >= vs.get(i)) {
9                num -= vs.get(i);
10                ans.append(cs.get(i));
11            }
12        }
13        return ans.toString();
14    }
15}