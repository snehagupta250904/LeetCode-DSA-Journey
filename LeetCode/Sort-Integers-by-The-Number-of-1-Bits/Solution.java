1class Solution {
2    public int[] sortByBits(int[] arr) {
3        int n = arr.length;
4        for (int i = 0; i < n; ++i) {
5            arr[i] += Integer.bitCount(arr[i]) * 100000;
6        }
7        Arrays.sort(arr);
8        for (int i = 0; i < n; ++i) {
9            arr[i] %= 100000;
10        }
11        return arr;
12    }
13}