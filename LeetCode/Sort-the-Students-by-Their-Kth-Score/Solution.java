1class Solution {
2    public int[][] sortTheStudents(int[][] score, int k) {
3        Arrays.sort(score, (a, b) -> b[k] - a[k]);
4        return score;
5    }
6}