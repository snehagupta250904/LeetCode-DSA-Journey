1class Solution {
2    public List<Integer> getRow(int rowIndex) {
3        List<Integer> f = new ArrayList<>();
4        for (int i = 0; i < rowIndex + 1; ++i) {
5            f.add(1);
6        }
7        for (int i = 2; i < rowIndex + 1; ++i) {
8            for (int j = i - 1; j > 0; --j) {
9                f.set(j, f.get(j) + f.get(j - 1));
10            }
11        }
12        return f;
13    }
14}