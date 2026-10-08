1class Solution {
2    public int numOfSubarrays(int[] arr, int k, int threshold) {
3        int s = 0;
4        for (int i = 0; i < k; ++i) {
5            s += arr[i];
6        }
7        int ans = s / k >= threshold ? 1 : 0;
8        for (int i = k; i < arr.length; ++i) {
9            s += arr[i] - arr[i - k];
10            ans += s / k >= threshold ? 1 : 0;
11        }
12        return ans;
13    }
14}