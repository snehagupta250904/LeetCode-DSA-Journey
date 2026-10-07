1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int n = arr.length;
4        int[] t = arr.clone();
5        Arrays.sort(t);
6        int m = 0;
7        for (int i = 0; i < n; ++i) {
8            if (i == 0 || t[i] != t[i - 1]) {
9                t[m++] = t[i];
10            }
11        }
12        int[] ans = new int[n];
13        for (int i = 0; i < n; ++i) {
14            ans[i] = Arrays.binarySearch(t, 0, m, arr[i]) + 1;
15        }
16        return ans;
17    }
18}