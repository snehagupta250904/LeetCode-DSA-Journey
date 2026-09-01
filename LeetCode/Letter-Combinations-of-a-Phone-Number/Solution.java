1class Solution {
2    public List<String> letterCombinations(String digits) {
3        List<String> ans = new ArrayList<>();
4        if (digits.length() == 0) {
5            return ans;
6        }
7        ans.add("");
8        String[] d = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
9        for (char i : digits.toCharArray()) {
10            String s = d[i - '2'];
11            List<String> t = new ArrayList<>();
12            for (String a : ans) {
13                for (String b : s.split("")) {
14                    t.add(a + b);
15                }
16            }
17            ans = t;
18        }
19        return ans;
20    }
21}