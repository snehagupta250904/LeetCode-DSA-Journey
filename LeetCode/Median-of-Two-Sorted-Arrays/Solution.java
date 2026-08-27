1class Solution {
2    private int m;
3    private int n;
4    private int[] nums1;
5    private int[] nums2;
6
7    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
8        m = nums1.length;
9        n = nums2.length;
10        this.nums1 = nums1;
11        this.nums2 = nums2;
12        int a = f(0, 0, (m + n + 1) / 2);
13        int b = f(0, 0, (m + n + 2) / 2);
14        return (a + b) / 2.0;
15    }
16
17    private int f(int i, int j, int k) {
18        if (i >= m) {
19            return nums2[j + k - 1];
20        }
21        if (j >= n) {
22            return nums1[i + k - 1];
23        }
24        if (k == 1) {
25            return Math.min(nums1[i], nums2[j]);
26        }
27        int p = k / 2;
28        int x = i + p - 1 < m ? nums1[i + p - 1] : 1 << 30;
29        int y = j + p - 1 < n ? nums2[j + p - 1] : 1 << 30;
30        return x < y ? f(i + p, j, k - p) : f(i, j + p, k - p);
31    }
32}