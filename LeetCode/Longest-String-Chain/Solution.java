1class Solution {
2    public int longestStrChain(String[] words) {
3        Arrays.sort(words, (a, b) -> a.length() - b.length());
4        Map<String, Integer> f = new HashMap<>();
5        int ans = 0;
6        for (String w : words) {
7            int x = 1;
8            for (int i = 0; i < w.length(); ++i) {
9                String pred = w.substring(0, i) + w.substring(i + 1);
10                x = Math.max(x, f.getOrDefault(pred, 0) + 1);
11            }
12            f.put(w, x);
13            ans = Math.max(ans, x);
14        }
15        return ans;
16    }
17}