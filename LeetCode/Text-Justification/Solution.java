1class Solution {
2    public List<String> fullJustify(String[] words, int maxWidth) {
3        List<String> ans = new ArrayList<>();
4        for (int i = 0, n = words.length; i < n;) {
5            List<String> t = new ArrayList<>();
6            t.add(words[i]);
7            int cnt = words[i].length();
8            ++i;
9            while (i < n && cnt + 1 + words[i].length() <= maxWidth) {
10                cnt += 1 + words[i].length();
11                t.add(words[i++]);
12            }
13            if (i == n || t.size() == 1) {
14                String left = String.join(" ", t);
15                String right = " ".repeat(maxWidth - left.length());
16                ans.add(left + right);
17                continue;
18            }
19            int spaceWidth = maxWidth - (cnt - t.size() + 1);
20            int w = spaceWidth / (t.size() - 1);
21            int m = spaceWidth % (t.size() - 1);
22            StringBuilder row = new StringBuilder();
23            for (int j = 0; j < t.size() - 1; ++j) {
24                row.append(t.get(j));
25                row.append(" ".repeat(w + (j < m ? 1 : 0)));
26            }
27            row.append(t.get(t.size() - 1));
28            ans.add(row.toString());
29        }
30        return ans;
31    }
32}