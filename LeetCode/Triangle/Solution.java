1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        for (int i = triangle.size() - 2; i >= 0; --i) {
4            for (int j = 0; j <= i; ++j) {
5                int x = triangle.get(i).get(j);
6                int y = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
7                triangle.get(i).set(j, x + y);
8            }
9        }
10        return triangle.get(0).get(0);
11    }
12}