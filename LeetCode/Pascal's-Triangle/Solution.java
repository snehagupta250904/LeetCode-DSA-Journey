1class Solution {
2    public List<List<Integer>> generate(int numRows) {
3        List<List<Integer>> f = new ArrayList<>();
4        f.add(List.of(1));
5        for (int i = 0; i < numRows - 1; ++i) {
6            List<Integer> g = new ArrayList<>();
7            g.add(1);
8            for (int j = 0; j < f.get(i).size() - 1; ++j) {
9                g.add(f.get(i).get(j) + f.get(i).get(j + 1));
10            }
11            g.add(1);
12            f.add(g);
13        }
14        return f;
15    }
16}