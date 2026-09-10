1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n = nums.length;
4        int[] ans = new int[n];
5        int k = 0;
6        for (int x : nums) {
7            if (x < pivot) {
8                ans[k++] = x;
9            }
10        }
11        for (int x : nums) {
12            if (x == pivot) {
13                ans[k++] = x;
14            }
15        }
16        for (int x : nums) {
17            if (x > pivot) {
18                ans[k++] = x;
19            }
20        }
21        return ans;
22    }
23}