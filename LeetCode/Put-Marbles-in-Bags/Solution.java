1class Solution {
2    public long putMarbles(int[] weights, int k) {
3        int n = weights.length;
4        int[] arr = new int[n - 1];
5        for (int i = 0; i < n - 1; ++i) {
6            arr[i] = weights[i] + weights[i + 1];
7        }
8        Arrays.sort(arr);
9        long ans = 0;
10        for (int i = 0; i < k - 1; ++i) {
11            ans -= arr[i];
12            ans += arr[n - 2 - i];
13        }
14        return ans;
15    }
16}